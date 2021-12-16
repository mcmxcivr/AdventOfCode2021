package nl.mcmxcivr.aoc2021.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowRiskPathFinderTest {

  @Test
  void test() {
    String input = "1163751742\n" +
      "1381373672\n" +
      "2136511328\n" +
      "3694931569\n" +
      "7463417111\n" +
      "1319128137\n" +
      "1359912421\n" +
      "3125421639\n" +
      "1293138521\n" +
      "2311944581";

    LowRiskPathFinder lowRiskPathFinder = LowRiskPathFinder.createFromString(input);
    assertEquals(40, lowRiskPathFinder.getShortestPathRiskLevel());
  }

  @Test
  void test5timesLarger() {
    String input = "1163751742\n" +
      "1381373672\n" +
      "2136511328\n" +
      "3694931569\n" +
      "7463417111\n" +
      "1319128137\n" +
      "1359912421\n" +
      "3125421639\n" +
      "1293138521\n" +
      "2311944581";

    LowRiskPathFinder lowRiskPathFinder = LowRiskPathFinder.createXtimesLargerFromString(input, 5);
    assertEquals(315, lowRiskPathFinder.getShortestPathRiskLevel());
  }
}