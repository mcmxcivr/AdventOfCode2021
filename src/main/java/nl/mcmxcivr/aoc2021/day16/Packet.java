package nl.mcmxcivr.aoc2021.day16;

import java.util.List;

class Packet {

  private final int version;
  private final int typeId;
  private final long literal;
  private final List<Packet> packets;

  Packet(int version, int typeId, long literal, List<Packet> packets) {
    this.version = version;
    this.typeId = typeId;
    this.literal = literal;
    this.packets = packets;
  }

  long calculate() {
    return switch (typeId) {
      case 0 -> (packets.size() == 1) ? packets.get(0).calculate() :
        packets.stream().mapToLong(Packet::calculate).sum();
      case 1 -> (packets.size() == 1) ? packets.get(0).calculate() :
        packets.stream().mapToLong(Packet::calculate).reduce(1, (a, b) -> a * b);
      case 2 -> packets.stream().map(Packet::calculate).min(Long::compare).get();
      case 3 -> packets.stream().map(Packet::calculate).max(Long::compare).get();
      case 4 -> literal;
      case 5 -> (packets.get(0).calculate() > packets.get(1).calculate()) ? 1 : 0;
      case 6 -> (packets.get(0).calculate() < packets.get(1).calculate()) ? 1 : 0;
      case 7 -> (packets.get(0).calculate() == packets.get(1).calculate()) ? 1 : 0;
      default -> throw new IllegalStateException();
    };
  }

  int sumVersion() {
    int sum = this.version;
    for (var packet : packets) {
      sum += packet.sumVersion();
    }
    return sum;
  }
}
