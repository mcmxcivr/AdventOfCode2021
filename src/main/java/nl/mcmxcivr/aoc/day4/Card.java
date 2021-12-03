package nl.mcmxcivr.aoc.day4;

import java.util.Arrays;

class Card {

  private final Number[][] numbers;
  private final int sizeX;
  private final int sizeY;

  private Card(Number[][] numbers, int sizeX, int sizeY) {
    this.numbers = numbers;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  public static Card createCardFromString(String input) {
    Number[][] cardNumbers;
    int sizeX, sizeY;
    
    String[] rows = input.split("\n");
    sizeY = rows.length;
    sizeX = rows[0].length();
    cardNumbers = new Number[sizeX][sizeY];
    
    for (int i = 0; i < rows.length; i++) {
      String row = rows[i];

      String[] numbers = row.split("\\s+");
      numbers = Arrays.stream(numbers).filter(n -> !n.isBlank()).toArray(String[]::new);
      
      sizeX = numbers.length;
      for (int j = 0; j < rows.length; j++) {
        String number = numbers[j];
        cardNumbers[i][j] = new Number(Integer.parseInt(number));
      }
    }

    return new Card(cardNumbers, sizeX, sizeY);
  }

  public int mark(int toMark) {
    boolean horizontalPossible;
    
    for (int i = 0; i < sizeY; i++) {
      horizontalPossible = true;
      for (int j = 0; j < sizeX; j++) {
        Number current = numbers[i][j];
        if (current.getNumber() == toMark) {
          current.mark();
        }
        
        if (!current.isMarked()) {
          horizontalPossible = false;
        }
      }
      
      if (horizontalPossible) {
        return getScore(toMark);
      }
    }
    
    // check vertical
    boolean verticalPossible;
    for (int i = 0; i < sizeX; i++) {
      verticalPossible = true;
      for (int j = 0; j < sizeY; j++) {
        Number current = numbers[j][i];

        if (!current.isMarked()) {
          verticalPossible = false;
          break;
        }
      }
      if (verticalPossible) {
        return getScore(toMark);
      }
    }
    
    return -1;
  }
  
  int getScore(int justMarked) {
    int unmarked = 0;
    for (int i = 0; i < sizeY; i++) {
      for (int j = 0; j < sizeX; j++) {
        Number current = numbers[i][j];
        if (!current.isMarked()) {
          unmarked += current.getNumber();
        }
      }
    }
    return unmarked * justMarked;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < sizeY; i++) {
      for (int j = 0; j < sizeX; j++) {
        Number current = numbers[i][j];
        if (current.isMarked()) {
          stringBuilder.append("[").append(current).append("]");
        } else {
          stringBuilder.append(" ").append(current).append(" ");
        }
        stringBuilder.append(",");
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}