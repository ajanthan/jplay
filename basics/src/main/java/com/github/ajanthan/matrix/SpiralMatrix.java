package com.github.ajanthan.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> getSpiralMatrix(int[][] in) {
        List<Integer> ret = new ArrayList<>();
        int rowStart = 0, colStart = 0, rowEnd = in.length - 1, colEnd = in[0].length - 1;
        while (rowEnd >= rowStart && colEnd >= colStart) {

            for (int i = colStart; i <= colEnd; i++) {
                ret.add(in[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                ret.add(in[i][colEnd]);
            }
            colEnd--;
            if (rowEnd >= rowStart) {
                for (int i = colEnd; i >= colStart; i--) {
                    ret.add(in[rowEnd][i]);
                }
            }
            rowEnd--;
            if (colEnd >= colStart) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ret.add(in[i][colStart]);
                }
            }
            colStart++;
        }
        return ret;
    }
}
