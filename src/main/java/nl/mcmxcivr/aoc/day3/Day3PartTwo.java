package nl.mcmxcivr.aoc.day3;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Day3PartTwo {
  
  private int oxygen;
  private int co2; 
  private int answer;
      
  void calculateAnswers(List<String> numbers) {
      List<String> uno = walk(numbers, (amountUp, total) -> (amountUp >= (double) total / 2) ? '1' : '0');
      List<String> dos = walk(numbers, (amountUp, total) -> (amountUp >= (double) total / 2) ? '0' : '1');

      oxygen = Integer.parseInt(uno.get(0), 2);
      co2 = Integer.parseInt(dos.get(0), 2);
      answer = oxygen * co2;
    }

    private static List<String> walk(List<String> numbers, BiFunction<Long, Integer, Character> criteria) {
      List<String> leftOver = numbers;
      int numberLength = numbers.get(0).length();

      for (int position = 0; position < numberLength && leftOver.size() > 1; position++) {
        String column = getColumn(position, leftOver);
        char commonValue = getCommonValue(column, criteria);
        leftOver = getLeftOver(commonValue, position, leftOver);
      }
      return leftOver;
    }

    private static List<String> getLeftOver(int commonValue, int position, List<String> numbers) {
      return numbers.stream() //
        .filter(s -> s.charAt(position) == commonValue) //
        .collect(Collectors.toList());
    }

    private static String getColumn(int position, List<String> numbers) {
      return numbers.stream() //
        .map(s -> s.charAt(position)) //
        .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    private static char getCommonValue(String column, BiFunction<Long, Integer, Character> criteria) {
      long bitUp = column.chars() //
        .filter(c -> c == '1') //
        .count();
      return criteria.apply(bitUp, column.length());
    }

  int getOxygen() {
    return oxygen;
  }

  int getCo2() {
    return co2;
  }

  int getAnswer() {
    return answer;
  }
}