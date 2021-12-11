package nl.mcmxcivr.aoc2021.day11;

import java.util.ArrayList;
import java.util.List;

class Octopuses {

  private final byte[][] octopuses;
  private final int rowLength;
  private final int colLength;

  private Octopuses(byte[][] octopuses, int rowLength, int colLength) {
    this.octopuses = octopuses;
    this.rowLength = rowLength;
    this.colLength = colLength;
  }

  int getFlashesAfterSteps(int steps) {
    int totalFlashes = 0;

    for (int step = 1; step <= steps; step++) {
      List<String> visited = new ArrayList<>();
      for (int i = 0; i < rowLength; i++) {
        for (int j = 0; j < colLength; j++) {
          update(i, j, visited);
        }
      }
      totalFlashes += visited.size();
    }

    return totalFlashes;
  }

  int getMomentAllFlash() {
    int totalFlashesThisStep = 0;
    int totalOctopuses = this.rowLength * this.colLength;

    int step = 0;
    for (; totalFlashesThisStep < totalOctopuses; step++) {
      List<String> visited = new ArrayList<>();
      for (int i = 0; i < colLength; i++) {
        for (int j = 0; j < rowLength; j++) {
          update(i, j, visited);
        }
      }
      totalFlashesThisStep = visited.size();
    }

    return step;
  }

  private void flash(int i, int j, List<String> visited) {
    visited.add("" + i + j);

    update(i, j + 1, visited); // right
    update(i, j - 1, visited); // left
    update(i + 1, j, visited); // down
    update(i - 1, j, visited); // up
    update(i + 1, j + 1, visited); // right down 
    update(i - 1, j - 1, visited); // left up
    update(i - 1, j + 1, visited); // right up
    update(i + 1, j - 1, visited); // left down
  }

  private void update(int i, int j, List<String> visited) {
    if (i < 0 || i >= rowLength || j < 0 || j >= colLength || visited.contains("" + i + j)) {
      return;
    }
    byte newValue = (byte) (octopuses[i][j] + 1);
    if (newValue > 9) {
      flash(i, j, visited);
      newValue = 0;
    }
    octopuses[i][j] = newValue;
  }

  static Octopuses createFromString(String input) {
    String[] split = input.split("\n");
    int rowLength = split[0].length();
    int colLength = split.length;
    byte[][] octopuses = new byte[colLength][rowLength];

    for (int i = 0; i < colLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        char character = split[i].charAt(j);
        octopuses[i][j] = Byte.parseByte("" + character);
      }
    }
    return new Octopuses(octopuses, rowLength, colLength);
  }
}
