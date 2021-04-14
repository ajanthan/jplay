package com.github.ajanthan;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {
    @Test
    public void reverseNumberTest() {
        int[] ins = { 123, 234, 101, 200, 1 };
        int[] ans = { 321, 432, 101, 2, 1 };
        int res;
        for (int i = 0; i < ins.length; i++) {
            res = reverseNumber(ins[i]);
            System.out.printf("%d -> %d \n", ins[i], res);
            Assert.assertEquals(ans[i], res);
        }

    }

    public int reverseNumber(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        return ans;
    }
}
