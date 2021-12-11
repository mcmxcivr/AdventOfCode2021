package nl.mcmxcivr.aoc2021.day7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class CrabAligner {
  
  private final List<Integer> positions;
  
  private CrabAligner(List<Integer> positions) {
    this.positions = positions;
  }

  CrabPosition getLeastAmountOfFuelPosition() {
    return getLeastAmountOfFuelPosition(false);
  }

  CrabPosition getLeastAmountOfFuelPositionWithIncrementEachStep() {
    return getLeastAmountOfFuelPosition(true);
  }
  
  private CrabPosition getLeastAmountOfFuelPosition(boolean incrementEachStep) {
    int max = positions.stream().max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
    int leastAmountOfFuel = Integer.MAX_VALUE;
    int leastAmountPosition = -1;

    for (int position = 1; position <= max; position++) {
      int totalFuelForPosition = getTotalFuelForPosition(position, incrementEachStep);

      if (leastAmountOfFuel > totalFuelForPosition) {
        leastAmountOfFuel = totalFuelForPosition;
        leastAmountPosition = position;
      }
    }
    return new CrabPosition(leastAmountPosition, leastAmountOfFuel);
  }

  private int getTotalFuelForPosition(int position, boolean incrementEachStep) {
    int totalFuelForPosition = 0;

    for (var crabsPosition : positions) {
      int stepsToPosition = (crabsPosition >= position) ? crabsPosition - position : position - crabsPosition;
      int fuelCost = (incrementEachStep) ? IntStream.rangeClosed(0, stepsToPosition).sum() : stepsToPosition;
      totalFuelForPosition += fuelCost;
    }
    return totalFuelForPosition;
  }
  
  static CrabAligner createFromString(String input) {
    List<Integer> positions = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    return new CrabAligner(positions);
  }
}
