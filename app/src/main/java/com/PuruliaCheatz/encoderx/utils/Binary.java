package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Binary {
  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      sb.append(String.format("%8s", new Object[] {Integer.toBinaryString(c)}).replace(' ', '0'));
    }
    return sb.toString();
  }

  public static String decode(String str) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (true) {
      int i2 = i;
      if (i2 < str.length()) {
        sb.append((char) Integer.parseInt(str.substring(i2, i2 + 8), 2));
        i = i2 + 8;
      } else {
        return sb.toString();
      }
    }
  }
}
