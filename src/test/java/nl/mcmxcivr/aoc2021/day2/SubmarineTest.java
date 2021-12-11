package nl.mcmxcivr.aoc2021.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

  @Test
  void test() {
    String input = "forward 5\n" +
      "down 5\n" +
      "forward 8\n" +
      "up 3\n" +
      "down 8\n" +
      "forward 2";
    
    Submarine submarine = Submarine.fromString(input);
    
    assertEquals(150, submarine.calculateHorizontalAndDepthMultiplied());
    assertEquals(900, submarine.calculateHorizontalAndDepthMultipliedNewInterpretation());
  }
}