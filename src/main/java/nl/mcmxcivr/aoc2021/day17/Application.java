package nl.mcmxcivr.aoc2021.day17;

public class Application {

  public static void main(String[] args) {
    TrickShotCalculator trickShotCalculator = TrickShotCalculator.createFromString(DAY17_INPUT);
    System.out.println(trickShotCalculator.getHighestYReachingTrajectory());
    System.out.println(trickShotCalculator.getHits());
  }

  private static final String DAY17_INPUT = "target area: x=135..155, y=-102..-78";
}
