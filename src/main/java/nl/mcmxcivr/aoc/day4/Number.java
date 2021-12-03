package nl.mcmxcivr.aoc.day4;

class Number {
    private final int number;
    private boolean marked;

    public Number(int number) {
      this.number = number;
      this.marked = false;
    }
    
    public int getNumber() {
      return number;
    }

    public void mark() {
      this.marked = true;
    }

    public boolean isMarked() {
      return marked;
    }

  @Override
  public String toString() {
      return (number <= 9) ? " " + number : "" + number; 
  }
}