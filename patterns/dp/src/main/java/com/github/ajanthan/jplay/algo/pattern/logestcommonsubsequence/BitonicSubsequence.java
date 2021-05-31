package com.github.ajanthan.jplay.algo.pattern.logestcommonsubsequence;

public class BitonicSubsequence {

    public int getMaxLength(int[] nums) {
        int lis[] = new int[nums.length];
        int lds[] = new int[nums.length];
        int maxLength = 1;
        lis[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(1 + lis[j], lis[i]);
                }
            }
        }
        lds[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(1 + lds[j], lds[i]);
                }
            }
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
        }

        return maxLength;
    }
}
