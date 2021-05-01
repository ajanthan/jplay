package com.github.ajanthan.sorting;

public class Sorter {
    public static int[] InsertionSort(int[] in) {
        for (int i = 1; i < in.length; i++) {
            int key = in[i], j = i - 1;
            while (j >= 0 && in[j] > key) {
                in[j + 1] = in[j];
                j--;
            }
            in[j + 1] = key;
        }
        return in;
    }

    public static int[] SelectionSort(int[] in) {
        int minIndex;
        for (int i = 0; i < in.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j] < in[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = in[i];
            in[i] = in[minIndex];
            in[minIndex] = temp;
        }
        return in;
    }

    public static int[] MergeSort(int[] in) {
        return split(in, 0, in.length - 1);
    }

    public static int[] BubbleSort(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
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

    public static int[] QuickSort(int[] in) {
        quickSortHelper(in, 0, in.length - 1);
        return in;
    }

    private static void quickSortHelper(int[] in, int s, int e) {
        if (e == s) return;
        int pivot = getPivot(in, s, e);
        if (pivot > 0) {
            quickSortHelper(in, s, pivot - 1);
        }
        quickSortHelper(in, pivot, e);

    }

    //1, 3, 4, 5, 2
    private static int getPivot(int[] in, int s, int e) {
        int i = s, j = s, pivot = e;
        while (j < e) {
            if (in[j] <= in[pivot]) {
                int temp = in[j];
                in[j] = in[i];
                in[i] = temp;
                i++;
            }
            j++;

        }
        int temp = in[i];
        in[i] = in[pivot];
        in[pivot] = temp;
        return i;
    }
}
