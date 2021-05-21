package com.github.ajanthan.jplay.algo.pattern.fibnumber;

/**
 * Given a positive integer n, we have to find the total number of divisors for n.
 * <p>
 * Input : n = 25
 * Output : 3
 * Divisors are 1, 5 and 25.
 * <p>
 * Input : n = 24
 * Output : 8
 * Divisors are 1, 2, 3, 4, 6, 8
 * 12 and 24.
 */
public class Divisors {
    public int totalDivisorsV1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int totalDivisorsV2(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
