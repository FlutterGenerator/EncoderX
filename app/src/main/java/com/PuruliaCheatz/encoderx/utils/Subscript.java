package com.PuruliaCheatz.encoderx.utils;

import java.util.HashMap;
import java.util.Map;

public class Subscript {
  private static final Map<Character, String> SUBSCRIPT_MAP = createSubscriptMap();
  private static final Map<String, Character> REVERSE_SUBSCRIPT_MAP = createReverseSubscriptMap();

  public static String encode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (char c : input.toCharArray()) {
      String subscript = SUBSCRIPT_MAP.get(c);
      result.append(subscript != null ? subscript : c);
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
      boolean found = false;

      // Check for 2-character subscript first
      if (i + 2 <= input.length()) {
        String twoChar = input.substring(i, i + 2);
        Character original = REVERSE_SUBSCRIPT_MAP.get(twoChar);
        if (original != null) {
          result.append(original);
          i += 2;
          found = true;
        }
      }

      // Check for 1-character subscript if 2-character wasn't found
      if (!found && i < input.length()) {
        String oneChar = input.substring(i, i + 1);
        Character original = REVERSE_SUBSCRIPT_MAP.get(oneChar);
        result.append(original != null ? original : input.charAt(i));
        i++;
      }
    }
    return result.toString();
  }

  private static Map<Character, String> createSubscriptMap() {
    Map<Character, String> map = new HashMap<>();
    // Numbers
    map.put('0', "₀");
    map.put('1', "₁");
    map.put('2', "₂");
    map.put('3', "₃");
    map.put('4', "₄");
    map.put('5', "₅");
    map.put('6', "₆");
    map.put('7', "₇");
    map.put('8', "₈");
    map.put('9', "₉");

    // Symbols
    map.put('+', "₊");
    map.put('-', "₋");
    map.put('=', "₌");
    map.put('(', "₍");
    map.put(')', "₎");

    // Letters
    map.put('a', "ₐ");
    map.put('e', "ₑ");
    map.put('o', "ₒ");
    map.put('x', "ₓ");
    map.put((char) 601, "ₔ");
    map.put('h', "ₕ");
    map.put('k', "ₖ");
    map.put('l', "ₗ");
    map.put('m', "ₘ");
    map.put('n', "ₙ");
    map.put('p', "ₚ");
    map.put('s', "ₛ");
    map.put('t', "ₜ");
    map.put('i', "ᵢ");
    map.put('j', "ⱼ");
    map.put('r', "ᵣ");
    map.put('v', "ᵥ");
    map.put('w', "w");

    // Greek letters
    map.put((char) 946, "ᵦ");
    map.put((char) 947, "ᵧ");
    map.put((char) 961, "ᵨ");
    map.put((char) 966, "ᵩ");
    map.put((char) 967, "ᵪ");

    return map;
  }

  private static Map<String, Character> createReverseSubscriptMap() {
    Map<String, Character> reverseMap = new HashMap<>();
    for (Map.Entry<Character, String> entry : SUBSCRIPT_MAP.entrySet()) {
      reverseMap.put(entry.getValue(), entry.getKey());
    }
    return reverseMap;
  }
}
