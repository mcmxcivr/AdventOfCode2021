package nl.mcmxcivr.aoc.day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3PartTwoTest {

  @Test
  void test() {
    // Setup
    String testString = "00100\n" +
      "11110\n" +
      "10110\n" +
      "10111\n" +
      "10101\n" +
      "01111\n" +
      "00111\n" +
      "11100\n" +
      "10000\n" +
      "11001\n" +
      "00010\n" +
      "01010";
    String[] testArray = testString.split("\n");
    List<String> testInput = Arrays.asList(testArray);

    Day3PartTwo day3PartTwo = new Day3PartTwo();

    // SUT
    day3PartTwo.calculateAnswers(testInput);

    // Verify
    assertEquals(23, day3PartTwo.getOxygen());
    assertEquals(10, day3PartTwo.getCo2());
    assertEquals(230, day3PartTwo.getAnswer());
  }
}