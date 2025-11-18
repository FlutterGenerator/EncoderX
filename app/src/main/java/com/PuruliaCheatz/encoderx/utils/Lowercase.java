package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Lowercase {
  public static String encode(String str) {
    return new String(str.toLowerCase());
  }

  public static String decode(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    boolean z = true;
    for (char c : str.toCharArray()) {
      if (z && Character.isLetter(c)) {
        sb.append(Character.toUpperCase(c));
        z = false;
      } else {
        sb.append(Character.toLowerCase(c));
      }
      if (c == '.') {
        z = true;
      }
    }
    return sb.toString();
  }
}
