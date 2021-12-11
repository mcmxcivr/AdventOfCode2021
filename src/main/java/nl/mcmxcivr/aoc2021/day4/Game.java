package nl.mcmxcivr.aoc2021.day4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Game {
  
  private final List<Card> cards;
  
  private Game(List<Card> cards) {
    this.cards = cards;
  }

  static Game createFromString(String input) {
    List<Card> cardsList = new ArrayList<>();
    
    String[] cards = input.split("\n\n");
    
    for (String card: cards) {
      Card cardFromString = Card.createCardFromString(card);
      cardsList.add(cardFromString);
    }
    return new Game(cardsList);
  }

  public int getLastWinningScoreFromString(String drawnInput) {
    String[] drawn = drawnInput.split(",");
    int winningRow;

    for (String toMark: drawn) {
      int number = Integer.parseInt(toMark);
      Iterator<Card> iterator = cards.iterator();
      while (iterator.hasNext()) {
        Card card = iterator.next();
        winningRow = card.mark(number);

        if (winningRow != -1) {
          iterator.remove();
        }

        if (cards.size() == 0) {
          return card.getScore(number);
        }
      }
    }
    return -1;
  }

  public int getWinningScoreFromString(String drawnInput) {
    String[] drawn = drawnInput.split(",");
    int winningRow = -1;
    
    for (String toMark: drawn) {
      int number = Integer.parseInt(toMark);
      for (Card card : cards) {
        winningRow = card.mark(number);
        
        if (winningRow != -1) {
          return winningRow;
        }
      }
    }
    return winningRow;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for(Card card: cards) {
      stringBuilder.append(card.toString());
      stringBuilder.append("\n\n");
    }
    return stringBuilder.toString();
  }
}
