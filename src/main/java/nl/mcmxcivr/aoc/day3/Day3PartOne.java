package nl.mcmxcivr.aoc.day3;

class Day3PartOne {

  int getAnswer(String input) {
    
    String[] numbers = input.split("\n");
    char[][] turn = turn(numbers);

    String gammaBin = "";
    String epsilonBin = "";

    for (char[] chars : turn) {
      int gammaOn = 0;
      int gammaOf = 0;
      for (char c : chars) {
        if (c == '1')
          gammaOn++;
        if (c == '0') {
          gammaOf++;
        }
      }
      gammaBin += (gammaOn > gammaOf) ? 1 : 0;
      epsilonBin += (gammaOn > gammaOf) ? 0 : 1;
    }

    int gamma = Integer.parseInt(gammaBin, 2);
    int epsilon = Integer.parseInt(epsilonBin, 2);

   return epsilon * gamma;
  }

  private static char[][] turn(String[] numbers) {
    char[][] converted = new char[numbers[0].length()][numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      String number = numbers[i];
      char[] chars = new char[number.length()];
      number.getChars(0, number.length(), chars, 0);

      for (int j = 0; j < chars.length; j++) {
        char current = chars[j];
        converted[j][i] = current;
      }
    }
    return converted;
  }
}
