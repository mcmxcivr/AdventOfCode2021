package nl.mcmxcivr.aoc2021.day17;

public class TargetArea {

  private final int x1, x2, y1, y2;

  private TargetArea(int x1, int x2, int y1, int y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }

  boolean isWithinTargetArea(int x, int y) {
    return x >= x1 && x <= x2 && y >= y1 && y <= y2;
  }

  public int getX1() {
    return x1;
  }

  public int getX2() {
    return x2;
  }

  public int getY1() {
    return y1;
  }

  public int getY2() {
    return y2;
  }

  static TargetArea createFromString(String input) {
    String[] split = input.split(", y=");
    String yString = split[1];
    String xString = split[0].substring(15);

    String[] x = xString.split("\\.\\.");
    String[] y = yString.split("\\.\\.");

    return new TargetArea(Integer.parseInt(x[0]), Integer.parseInt(x[1]), Integer.parseInt(y[0]),
      Integer.parseInt(y[1]));
  }
}
