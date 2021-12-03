package nl.mcmxcivr.aoc.day4;

class Application {  
  
  public static void main(String[] args) {
    Game game = Game.createFromString(DAY4_INPUT_CARDS);
    System.out.println(game.getWinningScoreFromString(DAY4_INPUT_DRAWN));
    System.out.println(game.getLastWinningScoreFromString(DAY4_INPUT_DRAWN));
  }
  
  private static final String DAY4_INPUT_DRAWN = "46,12,57,37,14,78,31,71,87,52,64,97,10,35,54,36,27,84,80,94,99,22," +
    "0,11,30,44,86,59,66,7,90,21,51,53,92,8,76,41,39,77,42,88,29,24,60,17,68,13,79,67,50,82,25,61,20,16,6,3,81,19,85," +
    "9,28,56,75,96,2,26,1,62,33,63,32,73,18,48,43,65,98,5,91,69,47,4,38,23,49,34,55,83,93,45,72,95,40,15,58,74,70,89";

  private static final String DAY4_INPUT_CARDS = "37 72 60 35 89\n" +
    "32 49  4 77 82\n" +
    "30 26 27 63 88\n" +
    "29 43 16 34 58\n" +
    "48 33 96 79 94\n" +
    "\n" +
    "41 94 77 43 87\n" +
    " 2 17 82 96 25\n" +
    "95 49 32 12  9\n" +
    "59 33 67 71 64\n" +
    "88 54 93 85 30\n" +
    "\n" +
    "78 84 73 64 81\n" +
    " 6 66 54 21 15\n" +
    "72 88 69  5 93\n" +
    "11 96 38 95 44\n" +
    "13 41 94 55 48\n" +
    "\n" +
    " 5 14  2 82 33\n" +
    "56 26  0 84 92\n" +
    " 8 95 24 54 25\n" +
    "68 67 15 85 47\n" +
    "20 91 36 13 88\n" +
    "\n" +
    "39 26 33 65 32\n" +
    "78 72 80 51  0\n" +
    "35 64 60 18 31\n" +
    "93 59 83 54 74\n" +
    "86  5  9 98 69\n" +
    "\n" +
    " 0  8 20 18 70\n" +
    " 5 29 65 21 57\n" +
    "68 61 83 63 51\n" +
    "91 73 77 75 80\n" +
    "35 62 16 32 10\n" +
    "\n" +
    "51 78 58 67 93\n" +
    "50 14 99  5 31\n" +
    " 6 21 48 30 83\n" +
    "22 33 23  1 34\n" +
    " 2 72 57 54 42\n" +
    "\n" +
    "15 68  4 24 49\n" +
    "12  9 74 88 51\n" +
    "91 19 50 76 75\n" +
    "80 84 23 17 53\n" +
    "67 42 22 85 36\n" +
    "\n" +
    "41 78 11 69  9\n" +
    "90 25 98 65 77\n" +
    "97 53 37 84 89\n" +
    "58 63  5 55  1\n" +
    "24 10 74 20 82\n" +
    "\n" +
    "42 19 95 89 49\n" +
    "61 31 50 76  3\n" +
    "34 47 32 69 86\n" +
    "78 68 99 11 91\n" +
    "55 12 73 45 23\n" +
    "\n" +
    "24 53 95 64 14\n" +
    "40 29 71 57 97\n" +
    "62 70 25 22  2\n" +
    "88 68 33 82 59\n" +
    "72 38 76 78 43\n" +
    "\n" +
    "73 36 84 90 40\n" +
    "16  4 57  9 29\n" +
    "38 97 46 51 83\n" +
    "86 88 99 44 32\n" +
    "54 49 37 43 62\n" +
    "\n" +
    "18 66 17 49 27\n" +
    "24 93 91 87 72\n" +
    "54 37 77 43 10\n" +
    "88 80 60 15 79\n" +
    "47 68 12  2 69\n" +
    "\n" +
    " 9 23 13 57 68\n" +
    "38 97 63 88 98\n" +
    "96 62 65 82 58\n" +
    "61 83 29 47 40\n" +
    "21 86 20 16 56\n" +
    "\n" +
    "27 90 37 97 52\n" +
    "14 96 76 21 79\n" +
    " 0 43 63 81 56\n" +
    "42 62 23 55 74\n" +
    "45 72 77 44 47\n" +
    "\n" +
    " 8 78 63 24 87\n" +
    " 9 23 12 17 68\n" +
    "36 83 45 61 50\n" +
    "84 77 18 86 37\n" +
    "31 26 19 49 94\n" +
    "\n" +
    "72 84 59 48 40\n" +
    "92 98 35  1 80\n" +
    "83 15 85 63 39\n" +
    " 2 64 58 13 20\n" +
    "29 88 60 12 74\n" +
    "\n" +
    "21 94 52  6  4\n" +
    "89 70 39 23 64\n" +
    "96 87 31 54 14\n" +
    "88 35 83 13 56\n" +
    "84 10 98 48 68\n" +
    "\n" +
    "70 33 48 21 37\n" +
    "91 95 65 38 77\n" +
    "92 14 26 96 60\n" +
    "12  6 73 13 81\n" +
    "54 55  2 45 80\n" +
    "\n" +
    "60 11 67 95 28\n" +
    " 5 32  0 71 12\n" +
    "47 78 13 54 43\n" +
    "49 89 82 66 77\n" +
    "26 53 19 79  3\n" +
    "\n" +
    "81  9 53 72 29\n" +
    "56 35 60 44 45\n" +
    "42 94 96 88 64\n" +
    "15 92  4  6 14\n" +
    "97 11 17 61 63\n" +
    "\n" +
    "24 43 33  9 34\n" +
    "36 28 69 35  7\n" +
    "47  4 14 82 38\n" +
    "11  1 52  0 49\n" +
    "93 87 98 41  5\n" +
    "\n" +
    "37 79 99 34 77\n" +
    "38 26 25 95 70\n" +
    "28 78 40 33 86\n" +
    "41 57 96 10 24\n" +
    " 9 74 72 50 81\n" +
    "\n" +
    "18 96 52 29 61\n" +
    "38 90  1 48 51\n" +
    "78 11 27 55 97\n" +
    "33 21 87 93 67\n" +
    "79 46 94 45  2\n" +
    "\n" +
    "27 63  6 90 10\n" +
    " 3 60 24  5 89\n" +
    "78 72 76 54  8\n" +
    "33 22 87 51 58\n" +
    " 4 37 64 91 43\n" +
    "\n" +
    "63 73 87 80 89\n" +
    "29 14 95 48  3\n" +
    "71 55 69  9 67\n" +
    "30 99 19  2 86\n" +
    "26 72 88 85 37\n" +
    "\n" +
    "12 57 81 78 40\n" +
    "35  4 55 15 39\n" +
    "33 45 25 60 70\n" +
    "86 79 88 52  3\n" +
    "90 20 28 59 85\n" +
    "\n" +
    "92 51 98 47 99\n" +
    "41 78 65  4 46\n" +
    "19 87 39 89 17\n" +
    "12 23 36 29 44\n" +
    " 6 82 71 16 37\n" +
    "\n" +
    " 8 34 81 67 80\n" +
    "83 92 13 11 41\n" +
    "39 89 93 49 43\n" +
    "20 69  3 74 76\n" +
    "44 72 68 70 45\n" +
    "\n" +
    "66 39 94 98 28\n" +
    "72  4 25 77 76\n" +
    "56 41 84 59 40\n" +
    "36 87 18 44 73\n" +
    "29 45 79 55 95\n" +
    "\n" +
    "45 91  2 92 16\n" +
    "21 47 86 81 56\n" +
    "31 11 62  5 95\n" +
    "39  1 30 65 33\n" +
    "42 60 17 18 83\n" +
    "\n" +
    "86 11 77 30 43\n" +
    "51 88 73 98 94\n" +
    "72 63 38 56 10\n" +
    "57 92 49  7 41\n" +
    "79 75 34 23 54\n" +
    "\n" +
    "56 95  3 43 65\n" +
    "39 62 93 19 27\n" +
    "61 41 99 96 52\n" +
    " 4 92 77 98 70\n" +
    "16 54 11 17 57\n" +
    "\n" +
    " 6 63 10 71 58\n" +
    "64 70 50 92  0\n" +
    " 7 14 99 45 26\n" +
    "78 17 44 46 73\n" +
    "77 38 62 53 37\n" +
    "\n" +
    "31 82 67 55 27\n" +
    "57 58 84  6 15\n" +
    "14 41 49  8 85\n" +
    "12 32 91 42 19\n" +
    "23  1 87 54 29\n" +
    "\n" +
    "54 60 43 26  4\n" +
    "78 17 28 67  5\n" +
    "87 93 90 71 22\n" +
    "13 30 16 21 85\n" +
    "55 74 52  1 29\n" +
    "\n" +
    "50 16 70 32 33\n" +
    " 6 94 52 66 22\n" +
    "97 64 98 72 39\n" +
    "27 69 99 34 26\n" +
    "36 91 37 21 14\n" +
    "\n" +
    " 7 97 64 28 18\n" +
    "85 80 14 37 34\n" +
    "72  1 22 58 73\n" +
    "53  3 68 17  0\n" +
    "29 44 56 95 32\n" +
    "\n" +
    "30 66 93 24 92\n" +
    "48 80 79 86 27\n" +
    "89 13 62 94 81\n" +
    "70 65 61  8 54\n" +
    "96 97 20 90 34\n" +
    "\n" +
    "87 76  4  7 43\n" +
    "92 55 80 25 62\n" +
    "79  6 88 35 30\n" +
    "10 32  5 45 17\n" +
    "36 27 33 68 63\n" +
    "\n" +
    "72 69 27 88 41\n" +
    "34 53 42 84  3\n" +
    "58 18 22 66 65\n" +
    " 9 47 85 12 62\n" +
    "73 90 91 57 33\n" +
    "\n" +
    "67 16 50 58 52\n" +
    "68 70 84 98 69\n" +
    " 4 72  9 64  0\n" +
    "93 97 39 26  5\n" +
    " 3 37 79  7 82\n" +
    "\n" +
    "61 57 88 54 70\n" +
    "77  8 94 81 63\n" +
    "39 48 18 13 10\n" +
    "55 23 27  4 73\n" +
    " 3  5 64  0 96\n" +
    "\n" +
    "62 27  0 52 19\n" +
    "28 57 83 25 41\n" +
    " 5 59 24 33 80\n" +
    "37 85  2 86 43\n" +
    "22 94 50  8 20\n" +
    "\n" +
    "54 32 34 47 87\n" +
    "71 22 43 85 24\n" +
    "11 68 58 36 46\n" +
    "35 56 61 67 18\n" +
    "70 23 72  5 59\n" +
    "\n" +
    " 3 96 41 45 32\n" +
    "68  2 56 28 24\n" +
    "87 38 40 75 26\n" +
    "53 64 73 80 81\n" +
    "54 88 20  6 18\n" +
    "\n" +
    "64 55 51 96 47\n" +
    "59 35 49 67 71\n" +
    "36 91 61 76 68\n" +
    " 6 94 20  8 27\n" +
    "60 88 45  7 82\n" +
    "\n" +
    "87 94 51 91  1\n" +
    "96 60 28 97 37\n" +
    "26 27 74 53 35\n" +
    "88 89 11 77  8\n" +
    "73 47 18 59  6\n" +
    "\n" +
    "46 50 19 36 83\n" +
    "69 28  4 44 70\n" +
    "45 20 63 27  1\n" +
    "53 38  9 47 67\n" +
    "91 31 79 73 86\n" +
    "\n" +
    "45  3 98 91 60\n" +
    "40  7 78 34 83\n" +
    "52 73 59 13  4\n" +
    "38 15 82 86 79\n" +
    "42 11 17 20 62\n" +
    "\n" +
    "65 86 38 20 72\n" +
    "78 45 73 74 25\n" +
    "62 42 24 75  3\n" +
    "81  8 35 50 51\n" +
    "44 11 94 85 57\n" +
    "\n" +
    "13 86 55 65 96\n" +
    "53 18 43 76 20\n" +
    "41 14 32 52 38\n" +
    "90 59 80 68  7\n" +
    " 2 23 92 39 50\n" +
    "\n" +
    "96 62 85 24 14\n" +
    "37  5 11 91 45\n" +
    "61 28 23 34 77\n" +
    "43 48 20  0 21\n" +
    "10 35  2 26 97\n" +
    "\n" +
    "89  5 40 34 84\n" +
    "90  6 72 68 10\n" +
    "13 64 71 31 76\n" +
    "53 60  9 92 62\n" +
    "69 98  8 50  3\n" +
    "\n" +
    "17 86 10 75 79\n" +
    "67 94 78 40 56\n" +
    "11 85 82 50 46\n" +
    "53 39 22  9 61\n" +
    "59 73 72 33 45\n" +
    "\n" +
    "65 22 18 96 95\n" +
    "55 86 67 52 69\n" +
    "10  2 60 83 98\n" +
    "43 61 87 88 66\n" +
    "41 24  8 84 33\n" +
    "\n" +
    "31 53 98 70 91\n" +
    "33 34 48 83  9\n" +
    "40 39 29 71 65\n" +
    "69 10 62 30  4\n" +
    "52 21 11 93 75\n" +
    "\n" +
    " 8 94 53 85 89\n" +
    "13 84 58 59 29\n" +
    "97  7 21 25 96\n" +
    "45 54 34 22 63\n" +
    "37 17 49 68 67\n" +
    "\n" +
    "86 87 84 24 10\n" +
    "82 32 36 59 50\n" +
    " 8 62 79 71 43\n" +
    "49 23 85 69 58\n" +
    "21 66 42 25 56\n" +
    "\n" +
    "65 88 43 25 19\n" +
    "26 36 63  5  6\n" +
    "37 54 75  1 38\n" +
    "95 46 83 66 28\n" +
    " 4 90 80 99 85\n" +
    "\n" +
    "78 83  7 77 34\n" +
    "27 92 93 96 82\n" +
    "40 95 52 32 43\n" +
    "17 28 69 41 85\n" +
    "21 65 39 58 19\n" +
    "\n" +
    "11 84 28 90 36\n" +
    "74  4 62  5 46\n" +
    "22  8 45 40 98\n" +
    "12  6 30  9 82\n" +
    "37  2 53 29 41\n" +
    "\n" +
    "17 65 31 86 57\n" +
    "73 16 24 67 53\n" +
    "60 93 88 45 26\n" +
    "14 80 94  7 44\n" +
    "55 78 49  8 82\n" +
    "\n" +
    "95 38 81 25 76\n" +
    "29 13 83 47 12\n" +
    "17 69  4 43 28\n" +
    "63 84 39 52 34\n" +
    " 1 97 41 88  8\n" +
    "\n" +
    "70 40 16 83  3\n" +
    "15 49 20 74 48\n" +
    "71 30 21 28 84\n" +
    "29 10 97  1 18\n" +
    "57 50 63 35 69\n" +
    "\n" +
    "40 13 67  9 41\n" +
    "71 76  8 54 24\n" +
    "15 97 92 49 96\n" +
    "61 34 23 81 31\n" +
    "11 38 48 37 86\n" +
    "\n" +
    "77 36 32 75  7\n" +
    "38 18 84 26  2\n" +
    "19 13 99 83 20\n" +
    "35 51 74  6 27\n" +
    "71 48 15 66 69\n" +
    "\n" +
    "91 57 41  3 99\n" +
    "74 55 81 77 43\n" +
    "36 52 47 49 45\n" +
    "85 65  5 38 50\n" +
    "90 68 70 16  0\n" +
    "\n" +
    " 1 90 28 86 27\n" +
    "73 36 67 11 14\n" +
    "71 31 10 65 55\n" +
    "78 21 16 69 12\n" +
    "87 24 33 83 68\n" +
    "\n" +
    "90 17 10 84 45\n" +
    " 5 68 69 27 92\n" +
    " 6 63 98  3 46\n" +
    "94 48 59 34 43\n" +
    "39 88 12 33 73\n" +
    "\n" +
    "12 31 33 98 63\n" +
    "65 51 94 83 92\n" +
    "41 38 84 91 66\n" +
    "47 28 76 54  3\n" +
    "48 36 11 13 27\n" +
    "\n" +
    "51 84 96 16  8\n" +
    "64 26 74 30 48\n" +
    "29 41 68 97 87\n" +
    " 9 38  1 15 39\n" +
    "98  3 45 53 14\n" +
    "\n" +
    "53 70 90 95 86\n" +
    "35 22 85 45 66\n" +
    "93  0 83 30 88\n" +
    "64 57 68 36  3\n" +
    " 5 51 19 20 89\n" +
    "\n" +
    " 9 36 69 46 44\n" +
    "37  7 99 57 45\n" +
    "79 10 86 58 30\n" +
    "49 98 52 90 27\n" +
    "14 51 88 60 81\n" +
    "\n" +
    "73 97 91 19 48\n" +
    "76 43 18 83 67\n" +
    "62  9 11 82 55\n" +
    "24 17 33 53 22\n" +
    "75  8 56  1 21\n" +
    "\n" +
    "27 97 53  0 89\n" +
    "30 70  3 80 54\n" +
    "56 93 40 64 35\n" +
    "46 82  1 44 65\n" +
    " 6 59 45 32 34\n" +
    "\n" +
    "87 58 73 45 69\n" +
    "24 49 89 71 83\n" +
    "94  6 53 68 50\n" +
    "28 25 88 47  0\n" +
    "36 13 31 18 55\n" +
    "\n" +
    "52 63 37 66  9\n" +
    "34 77 57  6 55\n" +
    "85 80 97 78 74\n" +
    "95 75 67 96 29\n" +
    "22 73 92 69 47\n" +
    "\n" +
    "79 97 80 36 73\n" +
    "38 77 35 32 53\n" +
    " 2 37 29  6 89\n" +
    "78 91 15 47 34\n" +
    "11 52 64 84  0\n" +
    "\n" +
    "69 30 21 99 46\n" +
    "72  4 15 25 42\n" +
    "67 98 81 91 63\n" +
    "70 20 57 65 14\n" +
    " 0 78 19  8 87\n" +
    "\n" +
    "20  4 98 33 85\n" +
    "76 17 94 65 35\n" +
    "95 69 72 52 71\n" +
    "23 25 50 38 27\n" +
    "43 49 96 53 99\n" +
    "\n" +
    "16 27 34 65 36\n" +
    "10 40 84 60 82\n" +
    "80  2 54 67 70\n" +
    "52 94 79 17 56\n" +
    " 5 14 77 91 88\n" +
    "\n" +
    "32 90 50 66 39\n" +
    "30 16 14 20 10\n" +
    " 4 42 88 59 12\n" +
    "75 84 54 51 48\n" +
    "33 24 13 89 43\n" +
    "\n" +
    "78 42 34 65 51\n" +
    "75 72  3 99 61\n" +
    "15 50 59  8 89\n" +
    "71 18  9 54 53\n" +
    "43 39 97 56 19\n" +
    "\n" +
    "50 43 83  4 30\n" +
    "89 97 58 35 39\n" +
    "11 24 61 41 25\n" +
    "87 99 93 15 34\n" +
    "31 57  3 45 44\n" +
    "\n" +
    "70 21 63 24 38\n" +
    "34 23 88  7 51\n" +
    "43 18 76 46 49\n" +
    "60 78 47  8 12\n" +
    "11 66 98 25 74\n" +
    "\n" +
    "30 17 23 10 92\n" +
    "12 85 69 81 91\n" +
    "47 80 28 29 58\n" +
    "73 44 77 50 32\n" +
    "76 54 78 75 60\n" +
    "\n" +
    "71 53 86 48 98\n" +
    "90 37 79  8 56\n" +
    "99 42 97 36 15\n" +
    "31 85 34 10 40\n" +
    "43 89 57 72 51\n" +
    "\n" +
    "48  0 65 55 90\n" +
    "45 76 69 97  4\n" +
    "42 52 46 77 56\n" +
    "64 62 68 35 72\n" +
    "71 10 27 30 16\n" +
    "\n" +
    "41 69 63 88 57\n" +
    "25 56 23 78 80\n" +
    " 8 92 59 66 97\n" +
    "48 61 77 15 14\n" +
    "87 47 91 12 71\n" +
    "\n" +
    "51 46 15  2 49\n" +
    "48 33 23 16  4\n" +
    "80 41 43 59 83\n" +
    "62 13 20 63 85\n" +
    "99 30  7 87  8\n" +
    "\n" +
    "69 80 96 43 47\n" +
    "61 75 45 62 15\n" +
    "32 22 91 83 58\n" +
    "82 13 50 52  8\n" +
    "89 20 63 73 14\n" +
    "\n" +
    "40  2 96 52 73\n" +
    "25 27 26 43 34\n" +
    "60 38 80 78  5\n" +
    "83 63 48 10 66\n" +
    "97 46 53 74 86\n" +
    "\n" +
    "46  7  0 69 15\n" +
    "79 19 85 27 73\n" +
    "63 45  5 49 54\n" +
    "93 29 84 28 66\n" +
    "72 23 99  8 33\n" +
    "\n" +
    "20 72 85 99 49\n" +
    "69  0 10 52 23\n" +
    "88 56 28 67 21\n" +
    "16 91 83 54 81\n" +
    "14 73 32 30 59\n" +
    "\n" +
    "31 52 63 12  3\n" +
    "96 20 82  6 89\n" +
    "55 38  8 95 40\n" +
    " 5 60 84 81 75\n" +
    "51 14 65 27 61\n" +
    "\n" +
    "46 93  1 47 76\n" +
    " 8 98  7 16 63\n" +
    "44 78 17 14 92\n" +
    "42 62 20 12 68\n" +
    "56  3 74  6 21\n" +
    "\n" +
    " 8 94 11 40 44\n" +
    "43 92 78 91 18\n" +
    "75 80 12 54 26\n" +
    "67  9 45 22 21\n" +
    "86  1 90 36 30\n" +
    "\n" +
    "21 19 83 90  8\n" +
    "50 28 45 65 75\n" +
    "59 88 25 29 70\n" +
    "58 23  0 95 49\n" +
    "36 68 76 78 66\n" +
    "\n" +
    "77 28 43 56 97\n" +
    "73 71  8 72 46\n" +
    "23 25 70 69 41\n" +
    "90 17 34 67 48\n" +
    "32 75 81 63 21";
}
