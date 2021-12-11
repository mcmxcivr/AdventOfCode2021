package nl.mcmxcivr.aoc2021.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OctopusesTest {

  @Test
  void test() {
    String input = "5483143223\n" +
      "2745854711\n" +
      "5264556173\n" +
      "6141336146\n" +
      "6357385478\n" +
      "4167524645\n" +
      "2176841721\n" +
      "6882881134\n" +
      "4846848554\n" +
      "5283751526";

    Octopuses octopuses = Octopuses.createFromString(input);
    assertEquals(1656, octopuses.getFlashesAfterSteps(100));
    octopuses = Octopuses.createFromString(input);
    assertEquals(195, octopuses.getMomentAllFlash());
  }

}