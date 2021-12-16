package nl.mcmxcivr.aoc2021.day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacketDecoderTest {

  @Test
  void test() {
    PacketDecoder
      packetDecoder = PacketDecoder.createFromString("38006F45291200");
    assertEquals(9, packetDecoder.getPacketVersionSum());

    packetDecoder = PacketDecoder.createFromString("8A004A801A8002F478");
    assertEquals(16, packetDecoder.getPacketVersionSum());

    packetDecoder = PacketDecoder.createFromString("620080001611562C8802118E34");
    assertEquals(12, packetDecoder.getPacketVersionSum());

    packetDecoder = PacketDecoder.createFromString("C0015000016115A2E0802F182340");
    assertEquals(23, packetDecoder.getPacketVersionSum());

    packetDecoder = PacketDecoder.createFromString("A0016C880162017C3686B18A3D4780");
    assertEquals(31, packetDecoder.getPacketVersionSum());
  }

  @Test
  void test2() {
    PacketDecoder
      packetDecoder = PacketDecoder.createFromString("C200B40A82");
    assertEquals(3, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("04005AC33890");
    assertEquals(54, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("880086C3E88112");
    assertEquals(7, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("CE00C43D881120");
    assertEquals(9, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("D8005AC2A8F0");
    assertEquals(1, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("F600BC2D8F");
    assertEquals(0, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("9C005AC2F8F0");
    assertEquals(0, packetDecoder.calculateExpressions());

    packetDecoder = PacketDecoder.createFromString("9C0141080250320F1802104A08");
    assertEquals(1, packetDecoder.calculateExpressions());
  }

}