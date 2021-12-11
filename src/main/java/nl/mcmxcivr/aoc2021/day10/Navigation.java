package nl.mcmxcivr.aoc2021.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Navigation {

  private final List<String> lines;
  private final List<Stack<Character>> incomplete = new ArrayList<>();

  private Navigation(List<String> lines) {
    this.lines = lines;
  }

  long getMiddleScore() {
    List<Long> scores = new ArrayList<>();
    for (Stack<Character> stack : incomplete) {
      long score = 0;
      while (stack.size() > 0) {
        score *= 5;
        Character character = stack.pop();
        if ('(' == character) {
          score += 1;
        } else if ('[' == character) {
          score += 2;
        } else if ('{' == character) {
          score += 3;
        } else if ('<' == character) {
          score += 4;
        }
      }
      scores.add(score);
      scores.sort(Long::compareTo);
    }
    return scores.get((scores.size() - 1) / 2);
  }

  int getIllegalCharacterPoints() {
    int total = 0;
    List<Character> illegalCharacters = getIllegalCharacters();

    for (char character : illegalCharacters) {
      if (')' == character) {
        total += 3;
      } else if (']' == character) {
        total += 57;
      } else if ('}' == character) {
        total += 1197;
      } else if ('>' == character) {
        total += 25137;
      }
    }
    return total;
  }

  List<Character> getIllegalCharacters() {
    List<Character> illegal = new ArrayList<>();

    for (String line : lines) {
      boolean previousIncomplete = false;
      Stack<Character> stack = new Stack<>();
      char[] chars = line.toCharArray();
      for (char character : chars) {
        Character top = null;
        if (stack.size() != 0) {
          top = stack.peek();
        }
        if (')' == character && top != null) {
          if (top == '(') {
            stack.pop();
          } else {
            illegal.add(')');
            previousIncomplete = true;
            break;
          }
        } else if (']' == character && top != null) {
          if (top == '[') {
            stack.pop();
          } else {
            illegal.add(']');
            previousIncomplete = true;
            break;
          }
        } else if ('}' == character && top != null) {
          if (top == '{') {
            stack.pop();
          } else {
            illegal.add('}');
            previousIncomplete = true;
            break;
          }
        } else if ('>' == character && top != null) {
          if (top == '<') {
            stack.pop();
          } else {
            illegal.add('>');
            previousIncomplete = true;
            break;
          }
        } else {
          stack.push(character);
        }
      }
      if (!previousIncomplete && stack.size() > 0) {
        incomplete.add(stack);
      }
    }
    return illegal;
  }

  static Navigation createFromString(String input) {
    String[] split = input.split("\n");
    return new Navigation(Arrays.asList(split));
  }
}
