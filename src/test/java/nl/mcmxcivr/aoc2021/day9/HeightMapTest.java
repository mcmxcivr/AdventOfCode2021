package nl.mcmxcivr.aoc2021.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightMapTest {

  @Test
  void test() {
    String input = "2199943210\n" +
      "3987894921\n" +
      "9856789892\n" +
      "8767896789\n" +
      "9899965678";

    HeightMap heightMap = HeightMap.createFromString(input);

    assertEquals(15, heightMap.getRiskLevel());
    assertEquals(1134, heightMap.getLargestBasins());
  }
}