package com.PuruliaCheatz.encoderx.utils;

public class Rot13 {

  public static String encode(String input) {
    if (input == null) {
      return null;
    }

    StringBuilder result = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (Character.isLetter(c)) {
        char base = Character.isUpperCase(c) ? 'A' : 'a';
        c = (char) (base + ((c - base + 13) % 26));
      }
      result.append(c);
    }
    return result.toString();
  }

  public static String decode(String input) {
    // Для ROT13 декодирование идентично кодированию
    return encode(input);
  }

  // Альтернативный вариант с единым методом
  public static String transform(String input) {
    return encode(input);
  }
}
