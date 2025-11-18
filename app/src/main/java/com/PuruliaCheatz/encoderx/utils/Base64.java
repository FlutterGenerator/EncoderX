package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Base64 {
  public static String encode(String str) {
    return new String(android.util.Base64.encode(str.getBytes(), 0));
  }

  public static String decode(String str) {
    return new String(android.util.Base64.decode(str, 0));
  }
}
