package nl.mcmxcivr.aoc2021.day5;

import java.util.Objects;

class Line {
  
  int x1;
  int y1;
  int x2;
  int y2;
  
  public static Line createFromString(String input) {
    String[] split = input.split(" -> ");
    
    var left = split[0].split(",");
    var right = split[1].split(",");
    
    return new Line(Integer.parseInt(left[0]), Integer.parseInt(left[1]), Integer.parseInt(right[0]),
      Integer.parseInt(right[1]));
  }

  private Line(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Line line = (Line) o;
    return x1 == line.x1 && y1 == line.y1 && x2 == line.x2 && y2 == line.y2;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x1, y1, x2, y2);
  }
}
