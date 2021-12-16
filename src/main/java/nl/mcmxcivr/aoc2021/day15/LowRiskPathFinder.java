package nl.mcmxcivr.aoc2021.day15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LowRiskPathFinder {

  private final byte[][] nodes;
  private final Map<String, Integer> risks;
  private final Map<String, String> path;
  int rowLength;
  int colLength;

  public LowRiskPathFinder(byte[][] nodes, Map<String, Integer> risks, int rowLength, int colLength) {
    this.nodes = nodes;
    this.risks = risks;
    this.rowLength = rowLength;
    this.colLength = colLength;
    path = new HashMap<>();
  }

  int getShortestPathRiskLevel() {
    Set<String> unsettled = new HashSet<>(risks.keySet());
    unsettled.add("0,0");
    risks.put("0,0", 0);

    while (unsettled.size() > 0) {
      String toEvaluate = getLowestRiskNode(unsettled, risks);
      unsettled.remove(toEvaluate);
      evaluateAdjacents(toEvaluate, unsettled);
      System.out.println("size " + unsettled.size() + " of " + risks.size());
    }

    String target = (colLength - 1) + "," + (rowLength - 1);
    Map<String, Byte> path = getPath(target);
    return (path.values().stream().mapToInt(Byte::intValue).sum() - nodes[0][0]);
  }

  private void evaluateAdjacents(String toEvaluate, Set<String> unsettled) {
    int i = Byte.parseByte("" + toEvaluate.split(",")[0]);
    int j = Integer.parseInt("" + toEvaluate.split(",")[1]);

    Set<String> adjacents = getAdjacents(i, j);
    for (String adjacent : adjacents) {
      if (unsettled.contains(adjacent)) {
        int risk = nodes[i][j];
        int newRisk = risks.get(toEvaluate) + risk;
        if (risks.get(adjacent) > newRisk) {
          risks.put(adjacent, newRisk);
          unsettled.add(adjacent);
          path.put(adjacent, toEvaluate);
        }
      }
    }
  }

  private Set<String> getAdjacents(int i, int j) {
    Set<String> adjacents = new HashSet<>();

    if (j - 1 >= 0) { // left
      adjacents.add((i + "," + (j - 1)));
    }
    if (j + 1 < rowLength) {// right
      adjacents.add((i + "," + (j + 1)));
    }
    if (i - 1 >= 0) { // up
      adjacents.add((i - 1) + "," + j);
    }
    if (i + 1 < colLength) { // down
      adjacents.add((i + 1) + "," + j);
    }
    return adjacents;
  }

  private String getLowestRiskNode(Set<String> unsettled, Map<String, Integer> risks) {
    int lowestRisk = Integer.MAX_VALUE;
    String a = null;
    for (String n : unsettled) {
      Integer risk = risks.get(n);
      if (lowestRisk > risk) {
        lowestRisk = risk;
        a = n;
      }
    }
    return a;
  }

  private Map<String, Byte> getPath(String target) {
    Map<String, Byte> path = new HashMap<>();
    String step = target;
    if (this.path.get(step) == null) {
      return null;
    }
    int x = Integer.parseInt("" + step.split(",")[0]);
    int y = Integer.parseInt("" + step.split(",")[1]);
    path.put(step, nodes[x][y]);
    while (this.path.get(step) != null) {
      step = this.path.get(step);
      int i = Integer.parseInt("" + step.split(",")[0]);
      int j = Integer.parseInt("" + step.split(",")[1]);
      byte risk = nodes[i][j];
      path.put(step, risk);
    }
    return path;
  }

  static LowRiskPathFinder createFromString(String input) {
    String[] split = input.split("\n");
    int rowLength = split[0].length();
    int colLength = split.length;
    Map<String, Integer> risks = new HashMap<>();

    byte[][] nodes = new byte[colLength][rowLength];
    for (int i = 0; i < colLength; i++) {
      char[] chars = split[i].toCharArray();
      for (int j = 0; j < rowLength; j++) {
        nodes[i][j] = Byte.parseByte("" + chars[j]);
        risks.put(i + "," + j, Integer.MAX_VALUE);
      }
    }
    return new LowRiskPathFinder(nodes, risks, rowLength, colLength);
  }

  public static LowRiskPathFinder createXtimesLargerFromString(String input, int times) {
    String[] split = input.split("\n");
    int rowLength = (split[0].length() * times);
    int colLength = (split.length * times);
    Map<String, Integer> risks = new HashMap<>();
    int origRowLength = split[0].length();
    int origColLength = split.length;

    byte[][] nodes = new byte[colLength][rowLength];
    for (int x = 0; x < times; x++) {
      for (int y = 0; y < times; y++) {
        for (int i = 0; i < colLength / times; i++) {
          char[] chars = split[i].toCharArray();
          for (int j = 0; j < rowLength / times; j++) {
            int value = Integer.parseInt("" + (chars[j])) + (x) + (y);
            if (value > 9) {
              value = value % 9;
            }
            int de = i + (x * origRowLength);
            int be = j + (y * origColLength);
            nodes[de][be] = (byte) value;
            risks.put(de + "," + be, Integer.MAX_VALUE);
          }
        }
      }
    }
    return new LowRiskPathFinder(nodes, risks, rowLength, colLength);
  }
}
