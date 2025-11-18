package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Octal {
  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append(Integer.toOctalString(str.charAt(i)));
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  public static String decode(String str) {
    StringBuilder sb = new StringBuilder();
    for (String str2 : str.split(" ")) {
      sb.append((char) Integer.parseInt(str2, 8));
    }
    return sb.toString();
  }
}
