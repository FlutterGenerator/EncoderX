package com.PuruliaCheatz.encoderx.utils;

import java.util.HashMap;
import java.util.Map;

public class Superscript {
  private static final Map<Character, String> SUPERSCRIPT_MAP = createSuperScriptMap();
  private static final Map<String, Character> REVERSE_SUPERSCRIPT_MAP =
      createReverseSuperScriptMap();

  public static String encode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (char c : input.toCharArray()) {
      String superscript = SUPERSCRIPT_MAP.get(c);
      result.append(superscript != null ? superscript : c);
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

      // Check for 2-character superscript first
      if (i + 2 <= input.length()) {
        String twoChar = input.substring(i, i + 2);
        Character original = REVERSE_SUPERSCRIPT_MAP.get(twoChar);
        if (original != null) {
          result.append(original);
          i += 2;
          found = true;
        }
      }

      // Check for 1-character superscript if 2-character wasn't found
      if (!found && i < input.length()) {
        String oneChar = input.substring(i, i + 1);
        Character original = REVERSE_SUPERSCRIPT_MAP.get(oneChar);
        result.append(original != null ? original : input.charAt(i));
        i++;
      }
    }
    return result.toString();
  }

  private static Map<Character, String> createSuperScriptMap() {
    Map<Character, String> map = new HashMap<>();
    // Numbers
    map.put('0', "⁰");
    map.put('1', "¹");
    map.put('2', "²");
    map.put('3', "³");
    map.put('4', "⁴");
    map.put('5', "⁵");
    map.put('6', "⁶");
    map.put('7', "⁷");
    map.put('8', "⁸");
    map.put('9', "⁹");

    // Symbols
    map.put('+', "⁺");
    map.put('-', "⁻");
    map.put('=', "⁼");
    map.put('(', "⁽");
    map.put(')', "⁾");

    // Lowercase letters
    map.put('a', "ᵃ");
    map.put('b', "ᵇ");
    map.put('c', "ᶜ");
    map.put('d', "ᵈ");
    map.put('e', "ᵉ");
    map.put('f', "ᶠ");
    map.put('g', "ᵍ");
    map.put('h', "ʰ");
    map.put('i', "ⁱ");
    map.put('j', "ʲ");
    map.put('k', "ᵏ");
    map.put('l', "ˡ");
    map.put('m', "ᵐ");
    map.put('n', "ⁿ");
    map.put('o', "ᵒ");
    map.put('p', "ᵖ");
    map.put('q', "۹");
    map.put('r', "ʳ");
    map.put('s', "ˢ");
    map.put('t', "ᵗ");
    map.put('u', "ᵘ");
    map.put('v', "ᵛ");
    map.put('w', "ʷ");
    map.put('x', "ˣ");
    map.put('y', "ʸ");
    map.put('z', "ᶻ");

    // Uppercase letters
    map.put('A', "ᴬ");
    map.put('B', "ᴮ");
    map.put('C', "ᶜ");
    map.put('D', "ᴰ");
    map.put('E', "ᴱ");
    map.put('F', "ᶠ");
    map.put('G', "ᴳ");
    map.put('H', "ᴴ");
    map.put('I', "ᴵ");
    map.put('J', "ᴶ");
    map.put('K', "ᴷ");
    map.put('L', "ᴸ");
    map.put('M', "ᴹ");
    map.put('N', "ᴺ");
    map.put('O', "ᴼ");
    map.put('P', "ᴾ");
    map.put('Q', "ᑫ");
    map.put('R', "ᴿ");
    map.put('S', "ˢ");
    map.put('T', "ᵀ");
    map.put('U', "ᵁ");
    map.put('V', "ⱽ");
    map.put('W', "ᵂ");
    map.put('X', "ˣ");
    map.put('Y', "ʸ");
    map.put('Z', "ᶻ");

    return map;
  }

  private static Map<String, Character> createReverseSuperScriptMap() {
    Map<String, Character> reverseMap = new HashMap<>();
    for (Map.Entry<Character, String> entry : SUPERSCRIPT_MAP.entrySet()) {
      reverseMap.put(entry.getValue(), entry.getKey());
    }
    return reverseMap;
  }
}
