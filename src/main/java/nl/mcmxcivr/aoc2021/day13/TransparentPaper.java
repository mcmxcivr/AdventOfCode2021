package nl.mcmxcivr.aoc2021.day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TransparentPaper {

  private final Set<Dot> dots;
  private final List<Fold> folds;

  private TransparentPaper(Set<Dot> dots, List<Fold> folds) {
    this.dots = dots;
    this.folds = folds;
  }

  public Set<Dot> foldAll() {
    return fold(folds.size());
  }

  public Set<Dot> fold(int amount) {
    Set<Dot> newDots = new HashSet<>(this.dots);

    for (int i = 0; i < amount; i++) {
      Set<Dot> toAdd = new HashSet<>(newDots);
      Fold fold = folds.get(i);
      if (fold.direction() == 'y') {
        for (var dot : newDots) {
          if (dot.y() > fold.line()) {
            int difference = dot.y() - fold.line();
            int newY = dot.y() - difference * 2;
            toAdd.remove(dot);
            toAdd.add(new Dot(dot.x(), newY));
          }
        }
      }
      if (fold.direction() == 'x') {
        for (var dot : newDots) {
          if (dot.x() > fold.line()) {
            int difference = dot.x() - fold.line();
            int newX = dot.x() - difference * 2;
            toAdd.remove(dot);
            toAdd.add(new Dot(newX, dot.y()));
          }
        }
      }
      newDots = toAdd;
    }

    return newDots;
  }

  public void print(Set<Dot> dots) {
    int maxX = dots.stream().max(Comparator.comparingInt(Dot::x)).get().x();
    int maxy = dots.stream().max(Comparator.comparingInt(Dot::y)).get().y();

    Character[][] print = new Character[maxy + 1][maxX + 1];
    for (var dot : dots) {
      print[dot.y()][dot.x()] = '#';
    }

    for (int y = 0; y <= maxy; y++) {
      for (int x = 0; x <= maxX; x++) {
        if (print[y][x] != null) {
          System.out.print(print[y][x]);
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
  }

  static TransparentPaper createFromString(String input) {
    List<Fold> folds = new ArrayList<>();
    Set<Dot> dots = new HashSet<>();

    String[] inputSplit = input.split("\n\n");
    String[] dotsInput = inputSplit[0].split("\n");


    for (String dot : dotsInput) {
      String[] dotSplit = dot.split(",");
      int x = Integer.parseInt(dotSplit[0]);
      int y = Integer.parseInt(dotSplit[1]);
      dots.add(new Dot(x, y));
    }

    String[] foldsInput = inputSplit[1].split("\n");
    for (String fold : foldsInput) {
      fold = fold.replace("fold along ", "");
      String[] foldSplit = fold.split("=");

      folds.add(new Fold(foldSplit[0].charAt(0), Integer.parseInt(foldSplit[1])));
    }

    return new TransparentPaper(dots, folds);
  }
}
