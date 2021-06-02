package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

/**
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B.
 * C is said to be interleaving A and B, if it contains all characters of A and B and order of all
 * characters in individual strings is preserved
 * <p>
 * Input: strings: "XXXXZY", "XXY", "XXZ"
 * Output: XXXXZY is interleaved of XXY and XXZ
 * The string XXXXZY can be made by
 * interleaving XXY and XXZ
 * String:    XXXXZY
 * String 1:    XX Y
 * String 2:  XX  Z
 * <p>
 * Input: strings: "XXY", "YX", "X"
 * Output: XXY is not interleaved of YX and X
 * XXY cannot be formed by interleaving YX and X.
 * The strings that can be formed are YXX and XYX
 */
public class InterleavedString {
    public boolean isInterleavedV0(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) {
            return false;
        }
        return isInterleavedV0(a, 0, b, 0, "", c);
    }

    private boolean isInterleavedV0(String a, int i, String b, int j, String c, String s) {
        if (i == a.length() && j == b.length() && s.equals(c)) {
            return true;
        }
        boolean result = false;
        if (i < a.length()) {
            result |= isInterleavedV0(a, i + 1, b, j, c + a.charAt(i), s);
        }
        if (j < b.length()) {
            result |= isInterleavedV0(a, i, b, j + 1, c + b.charAt(j), s);
        }
        return result;
    }

    public boolean isInterleavedV1(String a, String b, String c) {
        return isInterleavedV0(a, 0, b, 0, "", c);
    }
}
