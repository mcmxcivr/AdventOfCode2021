package nl.mcmxcivr.aoc.day2;

class Submarine {

  private final String[] commands;
  
  private Submarine(String[] commands) {
    this.commands = commands;
  }

  int calculateHorizontalAndDepthMultiplied() {
    int depth = 0;
    int position = 0;

    for (String move : commands) {
      String[] split = move.split(" ");
      String command = split[0];
      int units = Integer.parseInt(split[1]);
      
      switch (command) {
        case "forward" -> position += units;
        case "down" -> depth += units;
        case "up" -> depth -= units;
        default -> {}
      }
    }
    return depth * position;
  }
  
  int calculateHorizontalAndDepthMultipliedNewInterpretation() {
    int depth = 0;
    int position = 0;
    int aim = 0;

    for (String move : commands) {
      String[] split = move.split(" ");
      String command = split[0];
      int units = Integer.parseInt(split[1]);

      switch (command) {
        case "forward" -> {
          position += units;
          depth += aim * units;
        }
        case "down" -> aim += units;
        case "up" -> aim -= units;
        default -> {}
      }
    }
    return depth * position;
  }

  static Submarine fromString(String input) {
    return new Submarine(input.split("\n"));
  }
}
