package nl.mcmxcivr.aoc.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrabAlignerTest {
  
  @Test
  void test() {
    String input = "16,1,2,0,4,2,7,1,2,14";
    CrabAligner crabAligner = CrabAligner.createFromString(input);

    CrabPosition position = crabAligner.getLeastAmountOfFuelPosition();
    
    assertEquals(2, position.position());
    assertEquals(37, position.fuel());
    
    position = crabAligner.getLeastAmountOfFuelPositionWithIncrementEachStep();

    assertEquals(5, position.position());
    assertEquals(168, position.fuel());
  }
}