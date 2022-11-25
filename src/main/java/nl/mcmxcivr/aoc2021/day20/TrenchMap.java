package nl.mcmxcivr.aoc2021.day20;

class TrenchMap {

  private static final char DARK_PIXEL = '.';
  private static final char LIGHT_PIXEL = '#';

  char[] enhancementAlgo;
  char[][] image;
  int rowLength;
  int colLength;

  private TrenchMap(char[] enhancementAlgo, char[][] image, int rowLength, int colLength) {
    this.enhancementAlgo = enhancementAlgo;
    this.image = image;
    this.rowLength = rowLength;
    this.colLength = colLength;
  }

  int countLightPixelsAfterTimes(int times) {
    int colLength = this.colLength;
    int rowLength = this.rowLength;
    char[][] newImage = image;

    for (int i = 0; i < times; i++) {
      newImage = createNewImage(colLength, rowLength, newImage);
      colLength = newImage.length;
      rowLength = newImage[0].length;
    }

    int total = 0;
    for (int i = 0; i < colLength; i++) {
      for (int j = 0; j < rowLength; j++) {
        if (newImage[i][j] == LIGHT_PIXEL) {
          total += 1;
        }
      }
    }
    return total;
  }

  private char[][] createNewImage(int colLength, int rowLength, char[][] image) {
    int newColLength = colLength + 4;
    int newRowLength = rowLength + 4;

    int offset = 2;
    char[][] newImage = new char[newColLength][newRowLength];
    for (int i = 0; i < newColLength; i++) {
      for (int j = 0; j < newRowLength; j++) {
        if (i >= offset && j >= offset && i < newColLength - offset && j < newRowLength - offset) {
          newImage[i][j] = image[i - offset][j - offset];
        } else {
          if (rowLength == this.rowLength) {
            newImage[i][j] = DARK_PIXEL;
          } else {
            newImage[i][j] = image[0][0] == DARK_PIXEL ? DARK_PIXEL : LIGHT_PIXEL;
          }
        }
      }
    }

    char[][] newNewImage = new char[newColLength][newRowLength];
    for (int i = 0; i < newColLength; i++) {
      for (int j = 0; j < newRowLength; j++) {
        int surroundingPixelsInt = getSurroundingPixelsInt(i, j, newColLength, newRowLength, newImage);
        newNewImage[i][j] = enhancementAlgo[surroundingPixelsInt];
      }
    }

    return newNewImage;
  }

  private int getSurroundingPixelsInt(int y, int x, int rowLength, int colLength, char[][] image) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (x + j >= 0 && y + i >= 0 && x + j < rowLength && y + i < colLength) {
          char c = image[y + i][x + j];
          stringBuilder.append((c == LIGHT_PIXEL) ? 1 : 0);
        } else {
          stringBuilder.append(image[0][0] == LIGHT_PIXEL ? 1 : 0);
        }
      }
    }
    return Integer.parseInt(stringBuilder.toString(), 2);
  }

  static TrenchMap createFromString(String enhancementAlgo, String inputImage) {
    String[] split = inputImage.split("\n");
    int rowLength = split[0].length();
    int colLength = split.length;
    char[][] image = new char[colLength][rowLength];

    for (int i = 0; i < colLength; i++) {
      char[] chars = split[i].toCharArray();
      System.arraycopy(chars, 0, image[i], 0, rowLength);
    }

    return new TrenchMap(enhancementAlgo.toCharArray(), image, rowLength, colLength);
  }
}
