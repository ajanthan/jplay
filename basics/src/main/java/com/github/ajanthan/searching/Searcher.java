package com.github.ajanthan.searching;

public class Searcher {
    public static int LinearSearch(int[] in, int x) {
        for (int i = 0; i < in.length; i++) {
            if (x == in[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] in, int x) {
        return BinarySearchHelper(in, 0, in.length - 1, x);
    }

    public static int BinarySearchHelper(int[] in, int s, int e, int x) {
        if (s == e) {
            if (in[s] == x) {
                return s;
            } else {
                return -1;
            }
        }
        int mid = s + (e - s) / 2;
        if (x == in[mid]) {
            return mid;
        } else if (x < in[mid]) {
            return BinarySearchHelper(in, s, mid - 1, x);
        } else {
            return BinarySearchHelper(in, mid + 1, e, x);
        }
    }

    public static int FindFirst(int[] in, int x) {
        int i = BinarySearchHelper(in, 0, in.length - 1, x);
        while (i > 0 && in[i] == in[i - 1]) {
            i--;
        }
        return i;
    }

    public static int FindLast(int[] in, int x) {
        int i = BinarySearchHelper(in, 0, in.length - 1, x);
        while (i < in.length && in[i] == in[i + 1]) {
            i++;
        }
        return i;
    }
}
