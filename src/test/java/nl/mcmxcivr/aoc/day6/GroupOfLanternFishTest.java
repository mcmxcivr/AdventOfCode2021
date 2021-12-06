package nl.mcmxcivr.aoc.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupOfLanternFishTest {

  @Test
  void testAmountAfterDays() {
    GroupOfLanternFish groupOfLanternFish = GroupOfLanternFish.createFromString("3,4,3,1,2");

    assertEquals(26,  groupOfLanternFish.getAmountAfterDays(18));
    assertEquals(5934,  groupOfLanternFish.getAmountAfterDays(80));
    assertEquals(26984457539L,  groupOfLanternFish.getAmountAfterDays(256));
  }
}