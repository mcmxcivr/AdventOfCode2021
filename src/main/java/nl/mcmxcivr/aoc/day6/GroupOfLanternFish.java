package nl.mcmxcivr.aoc.day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GroupOfLanternFish {

  private final List<Long> fishPerNumber;

  private GroupOfLanternFish(List<Long> fishPerNumber) {
    this.fishPerNumber = fishPerNumber;
  }

  long getAmountAfterDays(int days) {
    LinkedList<Long> fishPerNumber = new LinkedList<>(this.fishPerNumber);

    for (int i = 0; i < days; i++) {
      Long removed = fishPerNumber.remove();
      fishPerNumber.set(6, (fishPerNumber.get(6) + removed));
      fishPerNumber.add(removed);
    }
    return fishPerNumber.stream().reduce(0L, Long::sum);
  }

  static GroupOfLanternFish createFromString(String input) {
    List<Long> fishPerNumber = new ArrayList<>();
    String[] split = input.split(",");

    for (int i = 0; i <= 8; i++) {
      fishPerNumber.add(i, 0L);
      for (String s : split) {
        int number = Integer.parseInt(s);
        if (number == i) {
          fishPerNumber.set(i, (fishPerNumber.get(i) + 1));
        }
      }
    }
    return new GroupOfLanternFish(fishPerNumber);
  }
}
