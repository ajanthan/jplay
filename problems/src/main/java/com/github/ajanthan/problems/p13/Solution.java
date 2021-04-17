package com.github.ajanthan.problems.p13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
     */
    public int romanToIntV0(String s) {
        int ret = 0;
        char prev = 0, current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            switch (current) {
                case 'I':
                    ret += 1;
                    break;
                case 'V':
                    if ('I' == prev) {
                        ret += 3;
                    } else {
                        ret += 5;
                    }
                    break;
                case 'X':
                    if ('I' == prev) {
                        ret += 8;
                    } else {
                        ret += 10;
                    }
                    break;
                case 'L':
                    if ('X' == prev) {
                        ret += 30;
                    } else {
                        ret += 50;
                    }
                    break;
                case 'C':
                    if ('X' == prev) {
                        ret += 80;
                    } else {
                        ret += 100;
                    }
                    break;
                case 'D':
                    if ('C' == prev) {
                        ret += 300;
                    } else {
                        ret += 500;
                    }
                    break;
                case 'M':
                    if ('C' == prev) {
                        ret += 800;
                    } else {
                        ret += 1000;
                    }
                    break;
            }
            prev = current;

        }
        return ret;
    }

    public int romanToIntV1(String s) {
        int ret = 0, current;
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        ret += romans.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            current = romans.get(s.charAt(i));
            if (current < romans.get(s.charAt(i + 1))) {
                ret -= current;
            } else {
                ret += current;
            }
        }
        return ret;
    }
}
