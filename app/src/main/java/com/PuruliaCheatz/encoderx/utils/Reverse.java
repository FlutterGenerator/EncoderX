package com.PuruliaCheatz.encoderx.utils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_out/com.PuruliaCheatz.encoderx/classes.dex */
public class Reverse {
  public static String encode(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append(getReversedChar(str.charAt(i)));
    }
    return sb.toString();
  }

  public static String decode(String str) {
    return encode(str);
  }

  private static char getReversedChar(char c) {
    switch (c) {
      case '!':
        return (char) 161;
      case '\"':
      case '#':
      case '$':
      case '%':
      case '&':
      case '(':
      case ')':
      case '*':
      case '+':
      case '-':
      case '/':
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '@':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      default:
        return c;
      case '\'':
        return ',';
      case ',':
        return '\'';
      case '.':
        return (char) 729;
      case '?':
        return (char) 191;
      case 'A':
        return (char) 8704;
      case 'B':
        return 'q';
      case 'C':
        return (char) 390;
      case 'D':
        return 'p';
      case 'E':
        return (char) 398;
      case 'F':
        return (char) 8498;
      case 'G':
        return (char) 8513;
      case 'H':
        return 'H';
      case 'I':
        return 'I';
      case 'J':
        return (char) 383;
      case 'K':
        return (char) 670;
      case 'L':
        return (char) 741;
      case 'M':
        return 'W';
      case 'N':
        return 'N';
      case 'O':
        return 'O';
      case 'P':
        return (char) 1280;
      case 'Q':
        return (char) 908;
      case 'R':
        return (char) 7450;
      case 'S':
        return 'S';
      case 'T':
        return (char) 8869;
      case 'U':
        return (char) 8745;
      case 'V':
        return (char) 923;
      case 'W':
        return 'M';
      case 'X':
        return 'X';
      case 'Y':
        return (char) 8516;
      case 'Z':
        return 'Z';
      case 'a':
        return (char) 594;
      case 'b':
        return 'q';
      case 'c':
        return (char) 596;
      case 'd':
        return 'p';
      case 'e':
        return (char) 477;
      case 'f':
        return (char) 607;
      case 'g':
        return (char) 387;
      case 'h':
        return (char) 613;
      case 'i':
        return (char) 305;
      case 'j':
        return (char) 638;
      case 'k':
        return (char) 670;
      case 'l':
        return 'l';
      case 'm':
        return (char) 623;
      case 'n':
        return 'u';
      case 'o':
        return 'o';
      case 'p':
        return 'd';
      case 'q':
        return 'b';
      case 'r':
        return (char) 633;
      case 's':
        return 's';
      case 't':
        return (char) 647;
      case 'u':
        return 'n';
      case 'v':
        return (char) 652;
      case 'w':
        return (char) 653;
      case 'x':
        return 'x';
      case 'y':
        return (char) 654;
      case 'z':
        return 'z';
    }
  }
}
