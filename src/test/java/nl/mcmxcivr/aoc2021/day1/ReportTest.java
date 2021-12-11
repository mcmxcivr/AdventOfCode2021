package nl.mcmxcivr.aoc2021.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {
  
  @Test
  void test() {
    String input = "199\n" +
      "200\n" +
      "208\n" +
      "210\n" +
      "200\n" +
      "207\n" +
      "240\n" +
      "269\n" +
      "260\n" +
      "263";
    
    Report report = Report.fromString(input);
    
    assertEquals(7, report.getMeasurementIncreases());
    assertEquals(5, report.getMeasurementIncreasesInSlidingWindows());
  }
}