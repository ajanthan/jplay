package com.github.ajanthan.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pickKNumbers(int[] in, int k) {
        List<List<Integer>> res = new ArrayList<>();
        pickKNumbers(in, 0, k, res);
        return res;
    }

    private void pickKNumbers(int[] in, int j, int k, List<List<Integer>> res) {
        if (j == k - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                l.add(in[i]);
            }
            res.add(l);
            return;
        }
        for (int i = j; i < in.length; i++) {
            swap(in, j, i);
            pickKNumbers(in, j + 1, k, res);
        }
    }

    private void swap(int[] in, int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }
}
