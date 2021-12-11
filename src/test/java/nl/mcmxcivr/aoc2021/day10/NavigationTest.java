package nl.mcmxcivr.aoc2021.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NavigationTest {

  @Test
  void test() {
    String input = "[({(<(())[]>[[{[]{<()<>>\n" +
      "[(()[<>])]({[<{<<[]>>(\n" +
      "{([(<{}[<>[]}>{[]{[(<()>\n" +
      "(((({<>}<{<{<>}{[]{[]{}\n" +
      "[[<[([]))<([[{}[[()]]]\n" +
      "[{[{({}]{}}([{[{{{}}([]\n" +
      "{<[[]]>}<{[{[{[]{()[[[]\n" +
      "[<(<(<(<{}))><([]([]()\n" +
      "<{([([[(<>()){}]>(<<{{\n" +
      "<{([{{}}[<[[[<>{}]]]>[]]";

    Navigation navigation = Navigation.createFromString(input);

    assertEquals(26397, navigation.getIllegalCharacterPoints());
    assertEquals(288957, navigation.getMiddleScore());
  }

}