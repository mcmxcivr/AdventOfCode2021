package nl.mcmxcivr.aoc.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagramTest {

  @Test
  void testHorizontalVertical() {
    String lines = "0,9 -> 5,9\n" +
      "8,0 -> 0,8\n" +
      "9,4 -> 3,4\n" +
      "2,2 -> 2,1\n" +
      "7,0 -> 7,4\n" +
      "6,4 -> 2,0\n" +
      "0,9 -> 2,9\n" +
      "3,4 -> 1,4\n" +
      "0,0 -> 8,8\n" +
      "5,5 -> 8,2";
    Diagram diagram = Diagram.createFromString(lines);
    
    int overlapping = diagram.countOverlappingLinesHorizontalVertical(1);

    assertEquals(5, overlapping);
  }

  @Test
  void testDiagonal() {
    String lines = "0,9 -> 5,9\n" +
      "8,0 -> 0,8\n" +
      "9,4 -> 3,4\n" +
      "2,2 -> 2,1\n" +
      "7,0 -> 7,4\n" +
      "6,4 -> 2,0\n" +
      "0,9 -> 2,9\n" +
      "3,4 -> 1,4\n" +
      "0,0 -> 8,8\n" +
      "5,5 -> 8,2";
    Diagram diagram = Diagram.createFromString(lines);
    
    int overlappingWithDiagonal = diagram.countOverlappingLinesAllDirections(1);

    assertEquals(12, overlappingWithDiagonal);
  }
}