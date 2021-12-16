package nl.mcmxcivr.aoc2021.day14;

public class Application {

  public static void main(String[] args) {
    Polymer polymer = Polymer.createFromString(PAIR_INSERTION, POLYMER_TEMPLATE);
    System.out.println(polymer.step(10));
    System.out.println(polymer.step(40));
  }

  private static final String POLYMER_TEMPLATE = "VFHKKOKKCPBONFHNPHPN";

  private static final String PAIR_INSERTION = "VS -> B\n" +
    "HK -> B\n" +
    "FO -> P\n" +
    "NC -> F\n" +
    "VN -> C\n" +
    "BS -> O\n" +
    "HS -> K\n" +
    "NS -> C\n" +
    "CV -> P\n" +
    "NV -> C\n" +
    "PH -> H\n" +
    "PB -> B\n" +
    "PK -> K\n" +
    "HF -> P\n" +
    "FV -> C\n" +
    "NN -> H\n" +
    "VO -> K\n" +
    "VP -> P\n" +
    "BC -> B\n" +
    "KK -> S\n" +
    "OK -> C\n" +
    "PN -> H\n" +
    "SB -> V\n" +
    "KO -> P\n" +
    "KH -> C\n" +
    "KS -> S\n" +
    "FP -> B\n" +
    "PV -> B\n" +
    "BO -> C\n" +
    "OS -> H\n" +
    "NB -> S\n" +
    "SP -> C\n" +
    "HN -> N\n" +
    "FN -> B\n" +
    "PO -> O\n" +
    "FS -> O\n" +
    "NH -> B\n" +
    "SO -> P\n" +
    "OB -> S\n" +
    "KC -> C\n" +
    "OO -> H\n" +
    "BB -> V\n" +
    "SC -> F\n" +
    "NP -> P\n" +
    "SH -> C\n" +
    "BH -> O\n" +
    "BP -> F\n" +
    "CC -> S\n" +
    "BN -> H\n" +
    "SS -> P\n" +
    "BF -> B\n" +
    "VK -> P\n" +
    "OV -> H\n" +
    "FC -> S\n" +
    "VB -> S\n" +
    "PF -> N\n" +
    "HH -> O\n" +
    "HC -> V\n" +
    "CH -> B\n" +
    "HP -> H\n" +
    "FF -> H\n" +
    "VF -> V\n" +
    "CS -> F\n" +
    "KP -> F\n" +
    "OP -> H\n" +
    "KF -> F\n" +
    "PP -> V\n" +
    "OC -> C\n" +
    "PS -> F\n" +
    "ON -> H\n" +
    "BK -> B\n" +
    "HV -> S\n" +
    "CO -> K\n" +
    "FH -> C\n" +
    "FB -> F\n" +
    "OF -> V\n" +
    "SN -> S\n" +
    "PC -> K\n" +
    "NF -> F\n" +
    "NK -> P\n" +
    "NO -> P\n" +
    "CP -> P\n" +
    "CK -> S\n" +
    "HB -> H\n" +
    "BV -> C\n" +
    "SF -> K\n" +
    "HO -> H\n" +
    "OH -> B\n" +
    "KV -> S\n" +
    "KN -> F\n" +
    "SK -> K\n" +
    "VH -> S\n" +
    "CN -> S\n" +
    "VC -> P\n" +
    "CB -> H\n" +
    "SV -> S\n" +
    "VV -> P\n" +
    "CF -> F\n" +
    "FK -> F\n" +
    "KB -> V";
}