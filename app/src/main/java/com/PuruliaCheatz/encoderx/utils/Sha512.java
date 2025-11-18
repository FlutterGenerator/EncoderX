package com.PuruliaCheatz.encoderx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Sha512 {
  public static String encode(String str) {
    try {
      byte[] digest = MessageDigest.getInstance("SHA-512").digest(str.getBytes());
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(String.format("%02x", new Object[] {new Byte(b)}));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static String decode(String str) {
    return new String("Decryption not possible!!");
  }

  public static boolean matches(String str, String str2) {
    return encode(str).equals(str2);
  }
}
