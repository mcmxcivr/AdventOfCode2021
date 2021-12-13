package nl.mcmxcivr.aoc2021.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathFinderTest {

  @Test
  void test() {
    PathFinder pathFinder = PathFinder.createFromString(input1);
    assertEquals(10, pathFinder.findAllPaths());

    pathFinder = PathFinder.createFromString(input2);
    assertEquals(19, pathFinder.findAllPaths());

    pathFinder = PathFinder.createFromString(input3);
    assertEquals(226, pathFinder.findAllPaths());
  }

  @Test
  void test2() {
    PathFinder pathFinder = PathFinder.createFromString(input1);
    assertEquals(36, pathFinder.findAllPathsWithPassSmallCaveForFreeCard());

    pathFinder = PathFinder.createFromString(input2);
    assertEquals(103, pathFinder.findAllPathsWithPassSmallCaveForFreeCard());

    pathFinder = PathFinder.createFromString(input3);
    assertEquals(3509, pathFinder.findAllPathsWithPassSmallCaveForFreeCard());
  }

  String input1 = "start-A\n" +
    "start-b\n" +
    "A-c\n" +
    "A-b\n" +
    "b-d\n" +
    "A-end\n" +
    "b-end";
  
  String input2 = "dc-end\n" +
    "HN-start\n" +
    "start-kj\n" +
    "dc-start\n" +
    "dc-HN\n" +
    "LN-dc\n" +
    "HN-end\n" +
    "kj-sa\n" +
    "kj-HN\n" +
    "kj-dc";

  String input3 = "fs-end\n" +
    "he-DX\n" +
    "fs-he\n" +
    "start-DX\n" +
    "pj-DX\n" +
    "end-zg\n" +
    "zg-sl\n" +
    "zg-pj\n" +
    "pj-he\n" +
    "RW-he\n" +
    "fs-DX\n" +
    "pj-RW\n" +
    "zg-RW\n" +
    "start-pj\n" +
    "he-WI\n" +
    "zg-he\n" +
    "pj-fs\n" +
    "start-RW";
}