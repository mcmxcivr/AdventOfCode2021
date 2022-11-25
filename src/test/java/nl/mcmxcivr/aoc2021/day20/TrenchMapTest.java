package nl.mcmxcivr.aoc2021.day20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrenchMapTest {

  @Test
  void test() {
    String enhancementAlgo = "..#.#..#####.#.#.#.###.##.....###.##.#..###.####..#####..#....#..#..##..##" +
      "#..######.###...####..#..#####..##..#.#####...##.#.#..#.##..#.#......#.###" +
      ".######.###.####...#.##.##..#..#..#####.....#.#....###..#.##......#.....#." +
      ".#..#..##..#...##.######.####.####.#.#...#.......#..#.#.#...####.##.#....." +
      ".#..#...##.#.##..#...##.#.##..###.#......#.#.......#.#.#.####.###.##...#.." +
      "...####.#..#..#.##.#....##..#.####....##...##..#...#......#.#.......#....." +
      "..##..####..#...#.#.#...##..#.#..###..#####........#..####......#..#";

    String inputImage = "#..#.\n" +
      "#....\n" +
      "##..#\n" +
      "..#..\n" +
      "..###";

    TrenchMap trenchMap = TrenchMap.createFromString(enhancementAlgo, inputImage);
    assertEquals(35, trenchMap.countLightPixelsAfterTimes(2));
    assertEquals(3351, trenchMap.countLightPixelsAfterTimes(50));
  }
}