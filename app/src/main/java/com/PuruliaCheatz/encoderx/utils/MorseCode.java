package com.PuruliaCheatz.encoderx.utils;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
  private static final Map<Character, String> CHAR_TO_MORSE = createMorseCodeMap();
  private static final Map<String, Character> MORSE_TO_CHAR = createReverseMorseCodeMap();

  public static String encode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (char c : input.toCharArray()) {
      String morse = CHAR_TO_MORSE.get(Character.toUpperCase(c));
      result.append(morse != null ? morse : c).append(" ");
    }
    return result.toString().trim();
  }

  public static String decode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    String[] codes = input.split(" ");

    for (String code : codes) {
      if (!code.isEmpty()) { // Skip empty strings from multiple spaces
        Character character = MORSE_TO_CHAR.get(code);
        result.append(character != null ? character : code);
      }
    }
    return result.toString();
  }

  private static Map<Character, String> createMorseCodeMap() {
    Map<Character, String> map = new HashMap<>();
    // Letters (only uppercase needed since we convert input to uppercase)
    map.put('A', ".-");
    map.put('B', "-...");
    map.put('C', "-.-.");
    map.put('D', "-..");
    map.put('E', ".");
    map.put('F', "..-.");
    map.put('G', "--.");
    map.put('H', "....");
    map.put('I', "..");
    map.put('J', ".---");
    map.put('K', "-.-");
    map.put('L', ".-..");
    map.put('M', "--");
    map.put('N', "-.");
    map.put('O', "---");
    map.put('P', ".--.");
    map.put('Q', "--.-");
    map.put('R', ".-.");
    map.put('S', "...");
    map.put('T', "-");
    map.put('U', "..-");
    map.put('V', "...-");
    map.put('W', ".--");
    map.put('X', "-..-");
    map.put('Y', "-.--");
    map.put('Z', "--..");

    // Numbers
    map.put('0', "-----");
    map.put('1', ".----");
    map.put('2', "..---");
    map.put('3', "...--");
    map.put('4', "....-");
    map.put('5', ".....");
    map.put('6', "-....");
    map.put('7', "--...");
    map.put('8', "---..");
    map.put('9', "----.");

    // Punctuation and symbols
    map.put('.', ".-.-.-");
    map.put(',', "--..--");
    map.put('?', "..--..");
    map.put('!', "-.-.--");
    map.put(' ', "/");
    map.put('\'', ".----.");
    map.put('"', ".-..-.");
    map.put(':', "---...");
    map.put(';', "-.-.-.");
    map.put('(', "-.--.");
    map.put(')', "-.--.-");
    map.put('=', "-...-");
    map.put('+', ".-.-.");
    map.put('-', "-....-");
    map.put('_', "..--.-");
    map.put('@', ".--.-.");
    map.put('$', "...-..-");
    map.put('&', ".-...");
    map.put('/', "-..-.");
    map.put('[', "-.--.");
    map.put(']', "-.--.-");
    map.put('{', "-.--.");
    map.put('}', "-.--.-");
    map.put('^', ".--.");
    map.put('%', "-.-.-.");
    map.put('*', "-..-");
    map.put('<', ".-...");
    map.put('>', "-...-");
    map.put('|', ".-...");
    map.put('\\', ".-..-.");
    map.put('#', "...-.-");
    map.put('~', ".-.-");
    map.put('`', ".-..-.");

    return map;
  }

  private static Map<String, Character> createReverseMorseCodeMap() {
    Map<String, Character> reverseMap = new HashMap<>();
    for (Map.Entry<Character, String> entry : CHAR_TO_MORSE.entrySet()) {
      reverseMap.put(entry.getValue(), entry.getKey());
    }
    return reverseMap;
  }
}
