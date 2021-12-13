package nl.mcmxcivr.aoc2021.day12;

import java.util.List;
import java.util.Locale;

public class Node {

  private final String name;
  private final List<Node> adjacentNodes;

  Node(String name, List<Node> adjacentNodes) {
    this.name = name;
    this.adjacentNodes = adjacentNodes;
  }

  boolean isSmallCave() {
    return name.equals(name.toLowerCase(Locale.ROOT));
  }

  boolean isEnd() {
    return name.equals("end");
  }

  boolean isStart() {
    return name.equals("start");
  }

  public String getName() {
    return name;
  }

  public List<Node> getAdjacentNodes() {
    return adjacentNodes;
  }
}
