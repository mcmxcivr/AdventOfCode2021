package nl.mcmxcivr.aoc2021.day17;

import java.util.HashSet;
import java.util.Set;

public class TrickShotCalculator {

  private final TargetArea targetArea;

  int getHighestYReachingTrajectory() {
    int highestYPosition = 0;

    for (int velocityX = 0; velocityX <= targetArea.getX2(); velocityX++) {
      for (int velocityY = -1000; velocityY < 1000; velocityY++) {
        int highestYForHitPosition = getHighestYForHit(velocityX, velocityY);
        if (highestYForHitPosition != 0) {
          if (highestYForHitPosition > highestYPosition) {
            highestYPosition = highestYForHitPosition;
          }
        }
      }
    }
    return highestYPosition;
  }

  int getHits() {
    Set<Velocity> coordinates = new HashSet<>();

    for (int velocityX = 0; velocityX <= targetArea.getX2(); velocityX++) {
      for (int velocityY = -1000; velocityY < 1000; velocityY++) {
        if (doesHit(velocityX, velocityY)) {
          coordinates.add(new Velocity(velocityX, velocityY));
        }
      }
    }
    return coordinates.size();
  }

  private int getHighestYForHit(int initialXVelocity, int initialYVelocity) {
    boolean hasHit = false;
    int positionX = 0;
    int positionY = 0;
    int velocityX = initialXVelocity;
    int velocityY = initialYVelocity;

    int highestYForInitial = 0;

    while (movingTowardsTarget(positionX, positionY, velocityX)) {
      velocityX += Integer.compare(0, velocityX);
      velocityY -= 1;
      positionX += velocityX;
      positionY += velocityY;

      highestYForInitial = Math.max(positionY, highestYForInitial);

      if (targetArea.isWithinTargetArea(positionX, positionY)) {
        hasHit = true;
      }
    }
    return (hasHit) ? highestYForInitial : 0;
  }

  private boolean doesHit(int initialXVelocity, int initialYVelocity) {
    int positionX = 0;
    int positionY = 0;
    int velocityX = initialXVelocity;
    int velocityY = initialYVelocity;

    while (movingTowardsTarget(positionX, positionY, velocityX)) {
      positionX += velocityX;
      positionY += velocityY;

      velocityX += Integer.compare(0, velocityX);
      velocityY -= 1;

      if (targetArea.isWithinTargetArea(positionX, positionY)) {
        return true;
      }
    }
    return false;
  }

  boolean movingTowardsTarget(int xPos, int yPos, int xVelocity) {
    boolean yWithinBounds = !(xVelocity == 0 && xPos < targetArea.getX1()) && (yPos < 10000 && yPos > -10000);
    boolean overshotX = xPos < targetArea.getX2();
    return overshotX && yWithinBounds;
  }

  private TrickShotCalculator(TargetArea targetArea) {
    this.targetArea = targetArea;
  }

  public static TrickShotCalculator createFromString(String input) {
    return new TrickShotCalculator(TargetArea.createFromString(input));
  }
}
