package com.PuruliaCheatz.encoderx.utils;

import java.nio.charset.StandardCharsets;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Base16 {
  public static String encode(String str) {
    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02X", new Object[] {new Byte(b)}));
    }
    return sb.toString();
  }

  public static String decode(String str) {
    byte[] bArr = new byte[str.length() / 2];
    int i = 0;
    while (true) {
      int i2 = i;
      if (i2 < str.length()) {
        bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        i = i2 + 2;
      } else {
        return new String(bArr, StandardCharsets.UTF_8);
      }
    }
  }
}
