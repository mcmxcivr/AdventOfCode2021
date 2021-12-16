package nl.mcmxcivr.aoc2021.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

class PacketDecoder {

  private static final int LITERAL_VALUE = 4;
  private static final int MIN_PACKET_LENGTH = 11;

  private final List<Byte> bits;

  private PacketDecoder(List<Byte> bits) {
    this.bits = bits;
  }

  public int getPacketVersionSum() {
    ArrayList<Byte> bits = new ArrayList<>(this.bits);
    List<Packet> packets = decodePackets(bits, Integer.MAX_VALUE).packets;
    return packets.get(0).sumVersion();
  }

  public long calculateExpressions() {
    ArrayList<Byte> bits = new ArrayList<>(this.bits);
    List<Packet> packets = decodePackets(bits, Integer.MAX_VALUE).packets();
    return packets.get(0).calculate();
  }

  private ReturnValue decodePackets(List<Byte> bits, int maxPackets) {
    byte version;
    byte typeId;
    int packetLength;
    List<Packet> packets = new ArrayList<>();

    while (bits.size() >= MIN_PACKET_LENGTH && maxPackets > 0) {
      version = Byte.parseByte(getString(bits, 0, 3), 2);
      typeId = Byte.parseByte(getString(bits, 3, 6), 2);
      packetLength = 6;

      if (typeId == LITERAL_VALUE) {
        StringBuilder literal = new StringBuilder();
        int start = packetLength;
        byte mostSigBit;
        do {
          int end = start + 5;
          mostSigBit = bits.get(start);
          start += 1;
          literal.append(getString(bits, start, end));
          start += 4;
          packetLength += 5;
        }
        while (mostSigBit == 1);

        packets.add(new Packet(version, typeId, Long.parseLong(literal.toString(), 2), Collections.emptyList()));

      } else {
        byte lengthTypeId = bits.get(6);
        packetLength += 1;

        if (lengthTypeId == 0) {
          int length = Integer.parseInt(getString(bits, 7, 22), 2); // 15 bits
          packetLength += 15 + length;
          packets.add(new Packet(version, typeId, -1,
            decodePackets(bits.subList(22, 22 + length), Integer.MAX_VALUE).packets));

        } else {
          int length = Integer.parseInt(getString(bits, 7, 18), 2); // 11 bits
          int start = 18;
          ReturnValue returnValue = decodePackets(bits.subList(start, bits.size()), length);
          List<Packet> subPackets = returnValue.packets();
          Packet packet = new Packet(version, typeId, -1, subPackets);
          packets.add(packet);

          packetLength = bits.size() - returnValue.remainingBits();
        }
      }
      maxPackets--;
      bits = bits.subList(packetLength, bits.size());
    }
    return new ReturnValue(packets, bits.size());
  }

  private String getString(List<Byte> bits, int start, int end) {
    return bits.subList(start, end).stream().collect(Collector.of(
      StringBuilder::new,
      StringBuilder::append,
      StringBuilder::append,
      StringBuilder::toString));
  }

  public static PacketDecoder createFromString(String input) {
    char[] chars = input.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (var hexChar : chars) {
      stringBuilder.append(hexToBin(hexChar));
    }
    List<Byte> bits = new ArrayList<>();
    char[] binString = stringBuilder.toString().toCharArray();
    for (var binChar : binString) {
      bits.add(Byte.parseByte("" + binChar));
    }
    return new PacketDecoder(bits);
  }

  private static String hexToBin(char hex) {
    return switch (hex) {
      case '0' -> "0000";
      case '1' -> "0001";
      case '2' -> "0010";
      case '3' -> "0011";
      case '4' -> "0100";
      case '5' -> "0101";
      case '6' -> "0110";
      case '7' -> "0111";
      case '8' -> "1000";
      case '9' -> "1001";
      case 'A' -> "1010";
      case 'B' -> "1011";
      case 'C' -> "1100";
      case 'D' -> "1101";
      case 'E' -> "1110";
      case 'F' -> "1111";
      default -> throw new IllegalStateException("Unexpected value: " + hex);
    };
  }

  record ReturnValue(List<Packet> packets, int remainingBits) {
  }
}
