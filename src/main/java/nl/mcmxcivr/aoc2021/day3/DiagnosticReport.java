package nl.mcmxcivr.aoc2021.day3;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class DiagnosticReport {
  
  private final List<String> numbers;
  
  private DiagnosticReport(List<String> numbers) {
    this.numbers = numbers;
  }

  int calculateLifeSupportRating() {
    int oxygenGeneratorRating = calculateUsingFunction(this::getMostCommonBit);
    int co2scrubberRating = calculateUsingFunction(this::getLeastCommonBit);
    return oxygenGeneratorRating * co2scrubberRating;
  }

  int calculateCPowerConsumption() {
    StringBuilder gammaRateBuffer = new StringBuilder();
    StringBuilder epsilonRateBuffer = new StringBuilder();

    int numberLength = numbers.get(0).length();
    for (int i = 0; i < numberLength; i++) {
      gammaRateBuffer.append(getMostCommonBit(numbers, i));
      epsilonRateBuffer.append(getLeastCommonBit(numbers, i));
    }

    int gammaRate = Integer.parseInt(gammaRateBuffer.toString(), 2);
    int epsilonRate = Integer.parseInt(epsilonRateBuffer.toString(), 2);
    
    return gammaRate * epsilonRate;
  }

  static DiagnosticReport createFromString(String input) {
    List<String> numbers = Arrays.stream(input.split("\n")).toList();
    return new DiagnosticReport(numbers);
  }

  private int calculateUsingFunction(BiFunction<List<String>, Integer, Character> toKeepFunction) {
    List<String> leftOver = numbers;
    int numberLength = numbers.get(0).length();

    for (int position = 0; position < numberLength && leftOver.size() > 1; position++) {
      char toKeep = toKeepFunction.apply(leftOver, position);
      leftOver = getNumbersToKeep(leftOver, toKeep, position);
    }

    return Integer.parseInt(leftOver.get(0), 2);
  }

  private List<String> getNumbersToKeep(List<String> numbers, char toKeep, int position) {
    return numbers.stream().filter(number -> number.charAt(position) == toKeep).toList();
  }
  
  private char getMostCommonBit(List<String> numbers, int position) {
    long countUp = numbers.stream().filter(number -> number.charAt(position) == '1').count();
    return (countUp >= (double) numbers.size() / 2) ? '1' : '0';
  }
  
  private char getLeastCommonBit(List<String> numbers, int position) {
    long countUp = numbers.stream().filter(i -> i.charAt(position) == '1').count();
    return (countUp >= (double) numbers.size() / 2) ? '0' : '1';
  }
}
