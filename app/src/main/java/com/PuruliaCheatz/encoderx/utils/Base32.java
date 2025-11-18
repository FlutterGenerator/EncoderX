package com.PuruliaCheatz.encoderx.utils;

public class Base32 {
  private static final String BASE32_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
  private static final int MASK_5BITS = 0x1F; // 31 in decimal

  public static String encode(String str) {
    if (str == null) {
      return null;
    }

    byte[] bytes = str.getBytes();
    StringBuilder sb = new StringBuilder(((bytes.length * 8) + 4) / 5);

    int buffer = 0;
    int bufferLength = 0;

    for (int i = 0; i < bytes.length; ) {
      if (bufferLength < 5) {
        if (i < bytes.length) {
          buffer = (buffer << 8) | (bytes[i] & 0xFF);
          i++;
          bufferLength += 8;
        } else {
          int padding = 5 - bufferLength;
          buffer <<= padding;
          bufferLength += padding;
        }
      }

      int index = (buffer >> (bufferLength - 5)) & MASK_5BITS;
      bufferLength -= 5;
      sb.append(BASE32_ALPHABET.charAt(index));
    }

    return sb.toString();
  }

  public static String decode(String str) {
    if (str == null) {
      return null;
    }

    int[] values = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      values[i] = BASE32_ALPHABET.indexOf(str.charAt(i));
      if (values[i] == -1) {
        throw new IllegalArgumentException("Invalid Base32 character: " + str.charAt(i));
      }
    }

    int buffer = 0;
    int bufferLength = 0;
    StringBuilder sb = new StringBuilder(((str.length() * 5) + 7) / 8);

    for (int value : values) {
      buffer = (buffer << 5) | (value & MASK_5BITS);
      bufferLength += 5;

      if (bufferLength >= 8) {
        sb.append((char) ((buffer >> (bufferLength - 8)) & 0xFF));
        bufferLength -= 8;
      }
    }

    return sb.toString();
  }
}
