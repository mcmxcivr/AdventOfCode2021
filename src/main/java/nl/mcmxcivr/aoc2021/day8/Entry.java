package nl.mcmxcivr.aoc2021.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entry {

  private final String[] numbers = new String[10];
  private final List<String> uniqueSignalPatterns;
  private final List<String> fourDigitOutputValues;

  private Entry(List<String> uniqueSignalPatterns, List<String> fourDigitOutputValues) {
    this.uniqueSignalPatterns = uniqueSignalPatterns;
    this.fourDigitOutputValues = fourDigitOutputValues;
  }

  public int getOutputValue() {
    boolean hasUnknown = true;

    while (hasUnknown) {
      hasUnknown = false;
      for (String pattern : uniqueSignalPatterns) {
        if (getDigitsNumber(pattern) == -1) {
          hasUnknown = true;
        }
      }
    }
    return Integer.parseInt(fourDigitOutputValues.stream()
      .mapToInt(this::getDigitsNumber)
      .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
      .toString());
  }

  public int getUniqueValues() {
    return fourDigitOutputValues.stream().filter(this::hasUniqueLength).toList().size();
  }

  private int getDigitsNumber(String digit) {
    int length = digit.length();
    return switch (length) {
      case 2 -> setNumber(digit, 1);
      case 3 -> setNumber(digit, 7);
      case 4 -> setNumber(digit, 4);
      case 7 -> setNumber(digit, 8);
      case 5 -> calculate5length(digit);
      case 6 -> calculate6length(digit);
      default -> throw new IllegalStateException("Unexpected value: " + length);
    };
  }

  private int calculate5length(String digit) {
    int match = -1;
    if (numbers[1] != null && matches(numbers[1], digit) || numbers[7] != null && matches(numbers[7], digit)) {
      match = setNumber(digit, 3);
    } else if (numbers[4] != null) {
      int amountOfMatches = amountOfMatches(numbers[4], digit);
      if (amountOfMatches == 3) {
        match = setNumber(digit, 5);
      } else if (amountOfMatches == 2) {
        match = setNumber(digit, 2);
      }
    }
    return match;
  }

  private int calculate6length(String outputValue) {
    int match = -1;
    if (numbers[1] != null) {
      if (!matches(numbers[1], outputValue)) {
        match = setNumber(outputValue, 6);
      } else {
        if (numbers[4] != null) {
          if (matches(numbers[4], outputValue)) {
            match = setNumber(outputValue, 9);
          } else {
            match = setNumber(outputValue, 0);
          }
        }
      }
    }
    return match;
  }

  private int setNumber(String number, int index) {
    numbers[index] = number;
    return index;
  }

  private boolean matches(String a, String b) {
    return amountOfMatches(a, b) - a.length() == 0;
  }

  private int amountOfMatches(String a, String b) {
    int count = 0;
    for (char x : a.toCharArray()) {
      for (char y : b.toCharArray()) {
        if (x == y) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean hasUniqueLength(String outputValue) {
    return outputValue.length() == 2 || outputValue.length() == 3 || outputValue.length() == 4
      || outputValue.length() == 7;
  }

  static Entry createFromString(String input) {
    String[] split = input.split("\s\\|\s");
    List<String> signalPatterns = new ArrayList<>(Arrays.asList(split[0].split(" ")));
    List<String> outputValues = new ArrayList<>(Arrays.asList(split[1].split(" ")));

    return new Entry(signalPatterns, outputValues);
  }
}
