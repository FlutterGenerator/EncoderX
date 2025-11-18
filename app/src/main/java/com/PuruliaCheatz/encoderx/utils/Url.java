package com.PuruliaCheatz.encoderx.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Url {
  public static String encode(String str) {
    try {
      return URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
    } catch (Exception e) {
      e.printStackTrace();
      return (String) null;
    }
  }

  public static String decode(String str) {
    try {
      return URLDecoder.decode(str, StandardCharsets.UTF_8.toString());
    } catch (Exception e) {
      e.printStackTrace();
      return (String) null;
    }
  }
}
