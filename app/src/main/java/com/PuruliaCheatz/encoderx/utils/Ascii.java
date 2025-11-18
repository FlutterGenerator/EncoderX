package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Ascii {
  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      sb.append(c).append(" ");
    }
    return sb.toString().trim();
  }

  public static String decode(String str) {
    StringBuilder sb = new StringBuilder();
    for (String str2 : str.split(" ")) {
      sb.append((char) Integer.parseInt(str2));
    }
    return sb.toString();
  }
}
