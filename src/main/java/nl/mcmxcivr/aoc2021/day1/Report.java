package nl.mcmxcivr.aoc2021.day1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Report {

  private final List<Integer> depths;

  private Report(List<Integer> depths) {
    this.depths = depths;
  }
  
  int getMeasurementIncreases() {
    int numberOfIncreases = 0;
    int previousDepth = -1;
    for (int measurement : depths) {
      if (previousDepth != -1 && measurement > previousDepth) {
        numberOfIncreases++;
      }
      previousDepth = measurement;
    }
    return numberOfIncreases;
  }
  
  int getMeasurementIncreasesInSlidingWindows() {
    int previousNumberOfIncreases = -1;
    int numberOfIncreases = 0;
    LinkedList<Integer> window = new LinkedList<>();
    for (int measurement : depths) {

      window.add(measurement);
      if (window.size() == 3) {

        int total = window.stream().mapToInt(Integer::intValue).sum();
        if (previousNumberOfIncreases != -1 && total > previousNumberOfIncreases) {
          numberOfIncreases++;
        }

        previousNumberOfIncreases = total;
        window.remove();
      }
    }
    return numberOfIncreases;
  }

  static Report fromString(String input) {
    List<Integer> depths = Arrays.stream(input.split("\n")).map(Integer::parseInt).toList();
    return new Report(depths);
  }
}
