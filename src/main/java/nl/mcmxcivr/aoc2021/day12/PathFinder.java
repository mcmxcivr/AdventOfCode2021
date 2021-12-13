package nl.mcmxcivr.aoc2021.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PathFinder {

  private final Node startNode;
  private final List<Node> nodes;

  private PathFinder(Node node, List<Node> nodes) {
    this.startNode = node;
    this.nodes = nodes;
  }

  public int findAllPaths() {
    List<String> paths = new ArrayList<>();
    String currentPath = "";

    traversePath(startNode, currentPath, paths, false);

    return paths.size();
  }

  public int findAllPathsWithPassSmallCaveForFreeCard() {
    List<String> paths = new ArrayList<>();
    String currentPath = "";

    traversePath(startNode, currentPath, paths, true);

    return paths.size();
  }

  void traversePath(Node node, String currentPath, List<String> paths, boolean canPassSmallCaveTwiceOnce) {
    currentPath += node.getName() + "-";

    List<Node> adjacentNodes = node.getAdjacentNodes();
    for (var adjacent : adjacentNodes) {
      if (adjacent.isStart()) {
        continue;
      }
      if (adjacent.isEnd()) {
        if (!paths.contains(currentPath + adjacent.getName())) {
          paths.add(currentPath + adjacent.getName());
        }
        continue;
      }
      if (adjacent.isSmallCave()) {
        boolean deadEnd = !canPassSmallCaveTwiceOnce && (node.isSmallCave() && adjacent.getAdjacentNodes().size() == 1);
        boolean visited = !canPassSmallCaveTwiceOnce && currentPath.contains(adjacent.getName());
        boolean visitedTwice = canPassSmallCaveTwiceOnce && currentPath.contains(adjacent.getName()) &&
          containsSmallCaveTwice(currentPath);
        if (visited || deadEnd || visitedTwice) {
          continue;
        }
      }

      traversePath(adjacent, currentPath, paths, canPassSmallCaveTwiceOnce);
    }
  }

  private boolean containsSmallCaveTwice(String input) {
    for (var node : nodes) {
      if (!node.isStart() && !node.isEnd() && node.isSmallCave() && input.contains(node.getName())) {
        String toCheck = input.replaceFirst(node.getName(), "");
        if (toCheck.contains(node.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  static PathFinder createFromString(String input) {
    List<Node> nodes = new ArrayList<>();
    String[] edges = input.split("\n");
    for (var edge : edges) {
      String[] split = edge.split("-");
      String fromName = split[0];
      String toName = split[1];

      Node from = getNode(nodes, fromName);
      Node to = getNode(nodes, toName);

      from.getAdjacentNodes().add(to);
      to.getAdjacentNodes().add(from);
    }

    Node start = nodes.stream().filter(n -> n.getName().equals("start")).findFirst()
      .orElseThrow(IllegalStateException::new);

    return new PathFinder(start, nodes);
  }

  private static Node getNode(List<Node> nodes, String name) {
    Node node;
    Optional<Node> optionalTo = nodes.stream().filter(n -> n.getName().equals(name)).findFirst();
    if (optionalTo.isEmpty()) {
      Node newNode = new Node(name, new ArrayList<>());
      nodes.add(newNode);
      node = newNode;
    } else {
      node = optionalTo.get();
    }
    return node;
  }
}
