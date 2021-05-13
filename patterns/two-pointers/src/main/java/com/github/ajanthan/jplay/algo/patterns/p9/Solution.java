package com.github.ajanthan.jplay.algo.patterns.p9;

/*
Problem Challenge 2
Comparing Strings containing Backspaces (medium)
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
Example 1:
Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:
Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Example 3:
Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
Example 4:
Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.isEqual("xy#z", "xzz#"));
        System.out.println("Output: " + solution.isEqual("xy#z", "xyz#"));
        System.out.println("Output: " + solution.isEqual("xp#", "xyz##"));
        System.out.println("Output: " + solution.isEqual("xywrrmp", "xywrrmu#p"));
        System.out.println("Output: " + solution.isEqual("xy#", "xyz###"));
        System.out.println("Output: " + solution.isEqual("x#", "xyz###"));
    }

    //str1="xy#z", str2="xzz#"
    public boolean isEqual(String str1, String str2) {
        int i1 = str1.length() - 1, i2 = str2.length() - 1;
        char c1, c2;
        while (i1 >= 0 && i2 >= 0) {
            while (i1 >= 0 && str1.charAt(i1) == '#') {
                i1--;
                int count = 1;
                while (str1.charAt(i1) == '#') {
                    i1--;
                    count++;
                }
                i1 = i1 - count;
            }
            while (i2 >= 0 && str2.charAt(i2) == '#') {
                i2--;
                int count = 1;
                while (str2.charAt(i2) == '#') {
                    i2--;
                    count++;
                }
                i2 = i2 - count;
            }
            if (i1 < 0 && i2 < 0) return true;
            if (i1 < 0 || i2 < 0) return false;
            if (i1 >= 0 && i2 >= 0 && str1.charAt(i1) != str2.charAt(i2)) return false;
            i1--;
            i2--;
        }
        return true;
    }
}
