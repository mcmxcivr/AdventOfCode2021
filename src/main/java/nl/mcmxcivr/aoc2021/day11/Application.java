package nl.mcmxcivr.aoc2021.day11;

public class Application {

  public static void main(String[] args) {
    Octopuses octopuses = Octopuses.createFromString(DAY11_INPUT);
    System.out.println(octopuses.getFlashesAfterSteps(100));
    octopuses = Octopuses.createFromString(DAY11_INPUT);
    System.out.println(octopuses.getMomentAllFlash());
  }

  private static final String DAY11_INPUT =
    "6227618536\n" +
      "2368158384\n" +
      "5385414113\n" +
      "4556757523\n" +
      "6746486724\n" +
      "4881323884\n" +
      "4648263744\n" +
      "4871332872\n" +
      "4724128228\n" +
      "4316512167";
}
