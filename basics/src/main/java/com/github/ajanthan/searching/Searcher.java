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

        return 0;
    }
}
