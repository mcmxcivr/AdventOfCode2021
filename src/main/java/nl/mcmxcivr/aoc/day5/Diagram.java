package nl.mcmxcivr.aoc.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Diagram {

  private final List<Line> lines;
  
  private Diagram(List<Line> lines) {
    this.lines = lines;
  }

  private int countOverlappingLines(int largerThan, boolean alsoCountDiagonal) {
    Map<Coordinate, Integer> diagramMap = new HashMap<>();

    List<Coordinate> toAdd = new ArrayList<>();
    for (var line : lines) {
      boolean isStraight = line.y1 == line.y2 || line.x1 == line.x2;
      if ( isStraight || alsoCountDiagonal) {
        List<Coordinate> coordinates = getCoordinates(line, isStraight);
        toAdd.addAll(coordinates);
      }
    }

    for (Coordinate c : toAdd) {
      Integer integer = diagramMap.get(c);
      if (integer != null) {
        diagramMap.put(c, ++integer);
      } else {
        diagramMap.put(c, 1);
      }
    }

    return (int) diagramMap.entrySet().stream().filter(e -> e.getValue() > largerThan).count();
  }
  
  private List<Coordinate> getCoordinates(Line line, boolean isStraight) {
    List<Coordinate> coordinates = new ArrayList<>();
    int sx = Math.min(line.x1, line.x2);
    int lx = Math.max(line.x1, line.x2);
    int sy = Math.min(line.y1, line.y2);
    int ly = Math.max(line.y1, line.y2);

    if (isStraight) {
      for (int i = sx; i <= lx; i++) {
        for (int j = sy; j <= ly; j++) {
          coordinates.add(new Coordinate(i, j));
        }
      }
    }

    if (!isStraight) {
      boolean direction1 = (line.x2 > line.x1 && line.y2 > line.y1) || (line.x2 < line.x1 && line.y2 < line.y1);
      if (direction1) {
        for (int i = 0; i <= (lx - sx); i++) {
          int x = lx - i;
          int y = ly - i;
          coordinates.add(new Coordinate(x, y));
        }
      } else {
        for (int i = 0; i <= (lx - sx); i++) {
          int x = lx - i;
          int y = sy + i;
          coordinates.add(new Coordinate(x, y));
        }
      }
    }

    return coordinates;
  }

  public int countOverlappingLinesAllDirections(int largerThan) {
    return this.countOverlappingLines(largerThan, true);
  }
  
  public int countOverlappingLinesHorizontalVertical(int largerThan) {
    return this.countOverlappingLines(largerThan, false);
  }

  static Diagram createFromString(String input) {
    List<Line> lineList = Arrays.stream(input.split("\n")).map(Line::createFromString).toList();
    return new Diagram(lineList);
  }
}
