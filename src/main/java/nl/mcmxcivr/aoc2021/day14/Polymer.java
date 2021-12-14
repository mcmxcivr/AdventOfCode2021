package nl.mcmxcivr.aoc2021.day14;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Polymer {

  private final Map<String, Long> polymer;
  private final Map<String, Character> insertions;
  private final String input;

  private Polymer(Map<String, Long> polymer, Map<String, Character> insertions, String input) {
    this.polymer = polymer;
    this.insertions = insertions;
    this.input = input;
  }

  public long doit(int steps) {
    Map<String, Long> polymer = this.polymer;

    for (int i = 1; i <= steps; i++) {
      Map<String, Long> stepMap = new HashMap<>();
      Set<String> strings = polymer.keySet();
      for (var pair : strings) {
        Long amountToAdd = polymer.get(pair);

        Character b = insertions.get(pair);
        char a = pair.charAt(0);
        char c = pair.charAt(1);

        String ab = "" + a + b;
        if (stepMap.containsKey(ab)) {
          stepMap.put(ab, stepMap.get(ab) + amountToAdd);
        } else {
          stepMap.put(ab, amountToAdd);
        }

        String bc = "" + b + c;
        if (stepMap.containsKey(bc)) {
          stepMap.put(bc, stepMap.get(bc) + amountToAdd);
        } else {
          stepMap.put(bc, amountToAdd);
        }
      }
      polymer = stepMap;
    }

    Map<Character, Long> characterToCount = new HashMap<>();
    characterToCount.put(input.charAt(input.length() - 1), 1L);
    for (
      var entry : polymer.entrySet()) {
      char character = entry.getKey().charAt(0);
      if (characterToCount.containsKey(character)) {
        characterToCount.put(character, characterToCount.get(character) + entry.getValue());
      } else {
        characterToCount.put(character, entry.getValue());
      }
    }

    Map.Entry<Character, Long> max = characterToCount.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get();
    Map.Entry<Character, Long> min = characterToCount.entrySet().stream().min(Comparator.comparingLong(Map.Entry::getValue)).get();
    return max.getValue() - min.getValue();
  }

  static Polymer createFromString(String pairInsertion, String input) {
    Map<String, Character> insertions = new HashMap<>();
    String[] insertionStrings = pairInsertion.split("\n");
    for (var insertionString : insertionStrings) {

      String[] split = insertionString.split(" -> ");
      insertions.put(split[0], split[1].charAt(0));
    }

    Map<String, Long> polymer = new HashMap<>();

    Character prev = null;
    for (char current : input.toCharArray()) {
      if (prev != null) {
        if (polymer.containsKey("" + prev + current)) {
          polymer.put("" + prev + current, polymer.get("" + prev + current) + 1);
        } else {
          polymer.put("" + prev + current, 1L);
        }
      }
      prev = current;
    }

    return new Polymer(polymer, insertions, input);
  }
}
