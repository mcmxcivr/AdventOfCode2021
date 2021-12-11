package nl.mcmxcivr.aoc2021.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosticReportTest {
  
  @Test
  void test() {
    String input = "00100\n" +
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
    
    DiagnosticReport diagnosticReport = DiagnosticReport.createFromString(input);
    
    assertEquals(198, diagnosticReport.calculateCPowerConsumption());
    assertEquals(230, diagnosticReport.calculateLifeSupportRating());
  }
}