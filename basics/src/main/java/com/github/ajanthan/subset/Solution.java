package com.github.ajanthan.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    //Contagious sub-array
    public List<List<Integer>> getAllSubsets(int[] in) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());//[]
        for (int i = 0; i < in.length; i++) {
            for (int j = i; j < in.length; j++) {
                List<Integer> subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(in[k]);
                }
                result.add(subArray);
            }
        }
        return result;
    }

    public List<List<Integer>> getAllSubsetsBT(int[] in) {
        List<List<Integer>> result = new ArrayList<>();
        getAllSubsetsBT(in, 0, result);
        return result;
    }

    private void getAllSubsetsBT(int[] in, int i, List<List<Integer>> res) {
        if (i == in.length) return;
        if (i == 0) {
            res.add(new ArrayList<>());
        }
        if (i < in.length) {
            for (List<Integer> l : new ArrayList<>(res)) {
                List<Integer> temp = new ArrayList<>(l);
                temp.add(in[i]);
                res.add(temp);
            }
        } else {
            throw new RuntimeException("invalid input");
        }
        getAllSubsetsBT(in, i + 1, res);

    }
}
