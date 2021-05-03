package com.github.ajanthan.sorting;

public class SortedMerge {
    public void mergeV0(int[] a, int aSize, int[] b) {
        int[] result = new int[aSize + b.length];
        int i = 0, j = 0, k = 0;
        while (i < b.length && j < aSize && k < result.length) {
            if (a[j] < b[i]) {
                result[k] = a[j];
                j++;
            } else {
                result[k] = b[i];
                i++;
            }
            k++;
        }
        while (i < b.length && k < result.length) {
            result[k] = b[i];
            i++;
            k++;
        }
        while (j < aSize && k < result.length) {
            result[k] = a[j];
            j++;
            k++;
        }
        for (int l = 0; l < result.length && l < a.length; l++) {
            a[l] = result[l];
        }
    }

    public void mergeV1(int[] a, int aSize, int[] b) {
        int i = 0, j = 0;
        while (i < b.length && j < a.length) {
            if (a[j] > b[i]) {
                int temp = a[j], k = 1;
                a[j] = b[i];
                aSize++;
                while (k + j < aSize) {
                    int t = a[j + k];
                    a[j + k] = temp;
                    temp = t;
                    k++;
                }
                i++;
            }
            j++;
        }
        while (i < b.length && j < b.length) {
            a[j] = b[i];
            i++;
            j++;
        }
    }
}
