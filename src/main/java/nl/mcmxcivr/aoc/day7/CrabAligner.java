package nl.mcmxcivr.aoc.day7;

import java.util.Arrays;
import java.util.List;

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
      int totalFuelForPosition = getTotalFuelForPositionToTry(position, incrementEachStep);

      if (leastAmountOfFuel > totalFuelForPosition) {
        leastAmountOfFuel = totalFuelForPosition;
        leastAmountPosition = position;
      }
    }
    return new CrabPosition(leastAmountPosition, leastAmountOfFuel);
  }

  private int getTotalFuelForPositionToTry(int positionToTry, boolean incrementEachStep) {
    int totalFuelForPositionToTry = 0;

    for (var position : positions) {
      int fuelCost = 0;
      int steps;
      if (position >= positionToTry) {
        steps = position - positionToTry;
      } else {
        steps = positionToTry - position;
      }
      
      if (incrementEachStep) {
        for (int i = 1; i <= steps; i++) {
          fuelCost += i;
        }
      } else {
        fuelCost = steps;
      }
      
      totalFuelForPositionToTry += fuelCost;
    }
    return totalFuelForPositionToTry;
  }
  
  static CrabAligner createFromString(String input) {
    List<Integer> positions = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    return new CrabAligner(positions);
  }
}
