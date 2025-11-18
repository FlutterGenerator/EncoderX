package com.PuruliaCheatz.encoderx.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class MegatronFog {
  public static String decode(String str) {
    try {
      return new String(xor(android.util.Base64.decode(str, 2), "UTF-8"), "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return new String(xor(android.util.Base64.decode(str, 2), "UTF-8"));
    }
  }

  public static String encode(String str) {
    try {
      return new String(android.util.Base64.encode(xor(str.getBytes("UTF-8"), "UTF-8"), 2));
    } catch (UnsupportedEncodingException e) {
      return new String(android.util.Base64.encode(xor(str.getBytes(), "UTF-8"), 2));
    }
  }

  private static byte[] xor(byte[] bArr, String str) {
    int length = bArr.length;
    int length2 = str.length();
    int i = 0;
    int i2 = 0;
    while (true) {
      int i3 = i2;
      if (i < length) {
        int i4 = i3;
        if (i3 >= length2) {
          i4 = 0;
        }
        bArr[i] = (byte) (bArr[i] ^ str.charAt(i4));
        i++;
        i2 = i4 + 1;
      } else {
        return bArr;
      }
    }
  }
}
