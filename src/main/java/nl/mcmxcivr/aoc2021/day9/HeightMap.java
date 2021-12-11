package nl.mcmxcivr.aoc2021.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HeightMap {

  private final byte[][] heights;
  private final int rowLength;
  private final int colLength;

  private HeightMap(byte[][] heights, int rowLength, int colLength) {
    this.rowLength = rowLength;
    this.colLength = colLength;
    this.heights = heights;
  }

  int getRiskLevel() {
    int riskLevel = 0;
    for (int i = 0; i < colLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        if (isLowestPoint(i, j, Collections.emptySet())) {
          riskLevel += 1 + heights[i][j];
        }
      }
    }
    return riskLevel;
  }

  public long getLargestBasins() {
    List<Integer> totalsOfBasins = new ArrayList<>();
    for (int i = 0; i < colLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        Set<String> visited = new HashSet<>();
        if (isLowestPoint(i, j, visited)) {
          recurse(i, j, visited);
          totalsOfBasins.add(visited.size());
        }
      }
    }
    totalsOfBasins.sort((a, b) -> Integer.compare(b, a));
    return (long) totalsOfBasins.get(0) * totalsOfBasins.get(1) * totalsOfBasins.get(2);
  }

  private void recurse(int i, int j, Set<String> visited) {
    visited.add(i + "," + j);
    int x = heights[i][j];

    adjacent(i, j - 1, visited); // left
    adjacent(i, j + 1, visited); // right
    adjacent(i - 1, j, visited); // up
    adjacent(i + 1, j, visited); // down
  }

  private void adjacent(int i, int j, Set<String> visited) {
    if (i >= 0 && i < colLength && j >= 0 && j < rowLength
      && isLowestPoint(i, j, visited) && !visited.contains(i + "," + j)) {
      recurse(i, j, visited);
    }
  }

  private int getAdjacentNumber(int i, int j, Set<String> visited) {
    if (i >= 0 && i < colLength && j >= 0 && j < rowLength && !visited.contains(i + "," + j)) {
      return heights[i][j];
    }
    return 9;
  }

  private boolean isLowestPoint(int i, int j, Set<String> visited) {
    int left = getAdjacentNumber(i, j - 1, visited);
    int right = getAdjacentNumber(i, j + 1, visited);
    int up = getAdjacentNumber(i - 1, j, visited);
    int down = getAdjacentNumber(i + 1, j, visited);

    int current = heights[i][j];
    return current != 9 && current <= left && current <= right && current <= up && current <= down;
  }

  static HeightMap createFromString(String input) {
    String[] split = input.split("\n");
    int rowLength = split[0].length();
    int colLength = split.length;
    byte[][] heights = new byte[colLength][rowLength];

    for (int i = 0; i < colLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        char character = split[i].charAt(j);
        heights[i][j] = Byte.parseByte("" + character);
      }
    }
    return new HeightMap(heights, rowLength, colLength);
  }
}
