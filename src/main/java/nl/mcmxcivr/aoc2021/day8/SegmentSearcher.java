package nl.mcmxcivr.aoc2021.day8;

import java.util.Arrays;
import java.util.List;

class SegmentSearcher {

  private final List<Entry> entries;

  private SegmentSearcher(List<Entry> entries) {
    this.entries = entries;
  }

  public static SegmentSearcher createFromString(String input) {
    List<Entry> entries = Arrays.stream(input.split("\n")).map(Entry::createFromString).toList();
    return new SegmentSearcher(entries);
  }

  public int getAmountOfUniqueNumbers() {
    return entries.stream().mapToInt(Entry::getUniqueValues).sum();
  }

  public int decodeAndSumAllOutputValues() {
    return entries.stream().mapToInt(Entry::getOutputValue).sum();
  }
}
