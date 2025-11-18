package com.PuruliaCheatz.encoderx.utils;

import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class ZalgoString {
  private static final char[] UP_CHARS = {
    781, 782, 772, 773, 831, 785, 774, 784, 850, 855, 849, 775, 776, 778, 834, 835, 836, 842, 843,
    844, 771, 770, 780, 848, 768, 769, 779, 783, 786, 787, 788, 829, 777, 867, 868, 869, 870, 871,
    872, 873, 874, 875, 876, 877, 878, 879, 830, 859, 838, 794
  };
  private static final char[] DOWN_CHARS = {
    790, 791, 792, 793, 796, 797, 798, 799, 800, 804, 805, 806, 809, 810, 811, 812, 813, 814, 815,
    816, 817, 818, 819, 825, 826, 827, 828, 837, 839, 840, 841, 845, 846, 851, 852, 853, 854, 857,
    858, 803
  };
  private static final char[] MID_CHARS = {
    789, 795, 832, 833, 856, 801, 802, 807, 808, 820, 821, 822, 847, 860, 861, 862, 863, 864, 866,
    824, 823, 865, 1161
  };

  private static boolean isZalgo(char c) {
    for (int i = 0; i < UP_CHARS.length; i++) {
      if (c == UP_CHARS[i]) {
        return true;
      }
    }
    for (int i2 = 0; i2 < DOWN_CHARS.length; i2++) {
      if (c == DOWN_CHARS[i2]) {
        return true;
      }
    }
    for (int i3 = 0; i3 < MID_CHARS.length; i3++) {
      if (c == MID_CHARS[i3]) {
        return true;
      }
    }
    return false;
  }

  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    Random random = new Random(System.currentTimeMillis());
    for (int i = 0; i < str.length(); i++) {
      if (!isZalgo(str.charAt(i))) {
        sb.append(str.charAt(i));
        int nextInt = random.nextInt(16);
        int nextInt2 = random.nextInt(6);
        int nextInt3 = random.nextInt(16);
        for (int i2 = 0; i2 < nextInt; i2++) {
          sb.append(UP_CHARS[random.nextInt(UP_CHARS.length)]);
        }
        for (int i3 = 0; i3 < nextInt2; i3++) {
          sb.append(DOWN_CHARS[random.nextInt(DOWN_CHARS.length)]);
        }
        for (int i4 = 0; i4 < nextInt3; i4++) {
          sb.append(MID_CHARS[random.nextInt(MID_CHARS.length)]);
        }
      }
    }
    return sb.toString();
  }

  public static String decode(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      if (!isZalgo(charAt)) {
        sb.append(charAt);
      }
    }
    return sb.toString();
  }
}
