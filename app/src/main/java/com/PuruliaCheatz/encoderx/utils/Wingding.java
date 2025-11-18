package com.PuruliaCheatz.encoderx.utils;

import java.util.HashMap;
import java.util.Map;

public class Wingding {
  private static final Map<Character, Integer> WINGDING_MAP = createWingdingMap();
  private static final Map<Integer, Character> REVERSE_WINGDING_MAP = createReverseWingdingMap();

  public static String encode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    String upperCase = input.toUpperCase();

    for (int i = 0; i < upperCase.length(); i++) {
      char c = upperCase.charAt(i);
      Integer codePoint = WINGDING_MAP.get(c);

      if (codePoint != null) {
        result.appendCodePoint(codePoint);
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static String decode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    int i = 0;

    while (i < input.length()) {
      int codePoint = input.codePointAt(i);
      Character originalChar = REVERSE_WINGDING_MAP.get(codePoint);

      if (originalChar != null) {
        result.append(originalChar);
      } else {
        result.appendCodePoint(codePoint);
      }

      i += Character.charCount(codePoint);
    }
    return result.toString();
  }

  private static Map<Character, Integer> createWingdingMap() {
    Map<Character, Integer> map = new HashMap<>();
    // Symbols
    map.put('!', 9999);
    map.put('\"', 9986);
    map.put('#', 9985);
    map.put('$', 128083);
    map.put('%', 128365);
    map.put('&', 128366);
    map.put('\'', 128367);
    map.put('(', 9742);
    map.put(')', 9990);
    map.put('*', 128386);
    map.put('+', 128387);
    map.put(',', 128234);
    map.put('-', 128235);
    map.put('.', 128236);
    map.put('/', 128237);

    // Numbers
    map.put('0', 128193);
    map.put('1', 128194);
    map.put('2', 128196);
    map.put('3', 128463);
    map.put('4', 128464);
    map.put('5', 128452);
    map.put('6', 8987);
    map.put('7', 128430);
    map.put('8', 128432);
    map.put('9', 128434);

    // Letters
    map.put('A', 9996);
    map.put('B', 128076);
    map.put('C', 128077);
    map.put('D', 128078);
    map.put('E', 9756);
    map.put('F', 9758);
    map.put('G', 9757);
    map.put('H', 9759);
    map.put('I', 9995);
    map.put('J', 9786);
    map.put('K', 128528);
    map.put('L', 9785);
    map.put('M', 128163);
    map.put('N', 9760);
    map.put('O', 9872);
    map.put('P', 127985);
    map.put('Q', 9992);
    map.put('R', 9788);
    map.put('S', 128167);
    map.put('T', 10052);
    map.put('U', 128326);
    map.put('V', 10014);
    map.put('W', 128328);
    map.put('X', 10016);
    map.put('Y', 10017);
    map.put('Z', 9770);

    // Other characters
    map.put(' ', 32);
    // Add remaining characters as needed...

    return map;
  }

  private static Map<Integer, Character> createReverseWingdingMap() {
    Map<Integer, Character> reverseMap = new HashMap<>();
    for (Map.Entry<Character, Integer> entry : WINGDING_MAP.entrySet()) {
      reverseMap.put(entry.getValue(), entry.getKey());
    }
    return reverseMap;
  }
}
