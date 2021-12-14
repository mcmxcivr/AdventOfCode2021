package nl.mcmxcivr.aoc2021.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolymerTest {

  @Test
  void test() {
    String ins = "CH -> B\n" +
      "HH -> N\n" +
      "CB -> H\n" +
      "NH -> C\n" +
      "HB -> C\n" +
      "HC -> B\n" +
      "HN -> C\n" +
      "NN -> C\n" +
      "BH -> H\n" +
      "NC -> B\n" +
      "NB -> B\n" +
      "BN -> B\n" +
      "BB -> N\n" +
      "BC -> B\n" +
      "CC -> N\n" +
      "CN -> C";
    Polymer polymer = Polymer.createFromString(ins, "NNCB");
    assertEquals(1588, polymer.doit(10));
    assertEquals(2188189693529L, polymer.doit(40));
  }
}