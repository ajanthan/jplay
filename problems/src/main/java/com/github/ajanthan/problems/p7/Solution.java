package com.github.ajanthan.problems.p7;

public class Solution {
    final static int MIN_REV = Integer.MIN_VALUE / 10;
    final static int MAX_REV = Integer.MAX_VALUE / 10;

    public int reverse(int x) {

        int rev = 0, pop;
        while (x != 0) {
            pop = x % 10;
            if (rev > MAX_REV || (rev == MAX_REV && pop > 7)) return 0;
            if (rev < MIN_REV || (rev == MIN_REV && pop < -8)) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }
}
