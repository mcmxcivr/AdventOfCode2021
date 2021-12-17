package nl.mcmxcivr.aoc2021.day17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrickShotCalculatorTest {

  @Test
  void test() {
    TrickShotCalculator trickShotCalculator = TrickShotCalculator.createFromString("target area: x=20..30, y=-10..-5");
    assertEquals(45, trickShotCalculator.getHighestYReachingTrajectory());
    assertEquals(112, trickShotCalculator.getHits());
  }

}