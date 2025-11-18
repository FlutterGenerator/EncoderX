package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Unicode {
  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append("\\u").append(Integer.toHexString(str.charAt(i) | 0).substring(1));
    }
    return sb.toString();
  }

  public static String decode(String str) {
    StringBuilder sb = new StringBuilder();
    String[] split = str.split("\\\\u");
    for (int i = 1; i < split.length; i++) {
      sb.append((char) Integer.parseInt(split[i], 16));
    }
    return sb.toString();
  }
}
