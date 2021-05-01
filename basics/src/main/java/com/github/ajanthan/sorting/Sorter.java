package com.github.ajanthan.sorting;

public class Sorter {
    public static int[] MergeSort(int[] in) {
        return split(in, 0, in.length - 1);
    }

    public static int[] BubbleSort(int[] in) {
        for (int i = 0; i < in.length-1; i++) {
            for (int j = 0; j < in.length - 1 - i; j++) {
                if (in[j] > in[j + 1]) {
                    int temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;
                }
            }
        }
        return in;
    }

    private static int[] split(int[] in, int s, int e) {
        if (s == e) {
            return new int[]{ in[s] };
        }
        int mid = (e - s) / 2;
        int[] left = split(in, s, s + mid);
        int[] right = split(in, s + mid + 1, e);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                ret[i++] = left[l];
                l++;
            } else {
                ret[i++] = right[r];
                r++;
            }
        }
        while (l < left.length) {
            ret[i++] = left[l++];
        }
        while (r < right.length) {
            ret[i++] = right[r++];
        }
        return ret;
    }
}
