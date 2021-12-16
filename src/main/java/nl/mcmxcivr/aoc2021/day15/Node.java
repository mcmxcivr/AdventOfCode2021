package nl.mcmxcivr.aoc2021.day15;

import java.util.ArrayList;
import java.util.List;

public class Node {

  private final int risk;
  private final List<Node> adjacents = new ArrayList<>();

  Node(int risk) {
    this.risk = risk;
  }

  boolean hasAdjacents() {
    return adjacents.size() > 0;
  }

  int getRisk() {
    return risk;
  }

  List<Node> getAdjacents() {
    return adjacents;
  }

  @Override
  public String toString() {
    return "" + risk;
  }
}
