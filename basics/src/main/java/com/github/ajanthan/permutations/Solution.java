package com.github.ajanthan.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> getArrayPermutationsV0(int[] in) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        for (int i : in) {
            inList.add(i);
        }
        constructPermutations(new ArrayList<>(), inList, result);
        return result;
    }

    private void constructPermutations(List<Integer> prefix, List<Integer> ds, List<List<Integer>> perms) {
        if (ds.isEmpty()) {
            perms.add(prefix);
            return;
        }
        for (int i = 0; i < ds.size(); i++) {
            List<Integer> newPrefix = new ArrayList<>(prefix);
            List<Integer> newDs = new ArrayList<>(ds);
            newPrefix.add(newDs.remove(i));
            constructPermutations(newPrefix, newDs, perms);
        }
    }

    public List<List<Integer>> getArrayPermutations(int[] in) {
        List<List<Integer>> res = new ArrayList();
        getPermutationsHelper(in, 0, res);
        return res;
    }

    private void getPermutationsHelper(int[] in, int start, List<List<Integer>> res) {
        if (start >= in.length) {
            res.add(java.util.Arrays.stream(in).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < in.length - start; i++) {
            swap(in, i, start);
            getPermutationsHelper(in, start + 1, res);
            swap(in, i, start);
        }
    }

    private void swap(int[] in, int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }

    public List<String> getStringPermutations(String s) {
        List<String> res = new ArrayList<>();
        getStringPermutationsHelper("", s, res);
        return res;
    }

    private void getStringPermutationsHelper(String prefix, String ds, List<String> res) {
        if (ds.isEmpty()) {
            res.add(prefix);
            return;
        }
        for (int i = 0; i < ds.length(); i++) {
            getStringPermutationsHelper(prefix + ds.charAt(i), ds.substring(0, i) + ds.substring(i + 1, ds.length()), res);
        }
    }
}
