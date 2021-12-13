package nl.mcmxcivr.aoc2021.day12;

public class Application {

  public static void main(String[] args) {
    PathFinder pathFinder = PathFinder.createFromString(DAY12_INPUT);
    System.out.println(pathFinder.findAllPaths());
    System.out.println(pathFinder.findAllPathsWithPassSmallCaveForFreeCard());
  }

  private static final String DAY12_INPUT =
    "xq-XZ\n" +
      "zo-yr\n" +
      "CT-zo\n" +
      "yr-xq\n" +
      "yr-LD\n" +
      "xq-ra\n" +
      "np-zo\n" +
      "end-LD\n" +
      "np-LD\n" +
      "xq-kq\n" +
      "start-ra\n" +
      "np-kq\n" +
      "LO-end\n" +
      "start-xq\n" +
      "zo-ra\n" +
      "LO-np\n" +
      "XZ-start\n" +
      "zo-kq\n" +
      "LO-yr\n" +
      "kq-XZ\n" +
      "zo-LD\n" +
      "kq-ra\n" +
      "XZ-yr\n" +
      "LD-ws\n" +
      "np-end\n" +
      "kq-yr";
}
