package leetcoder;

import java.util.*;




class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length\;
        int n = matrix[0].length;
        int[][] work = new int[m][n];
        work[0][0] = matrix[0][0];
        for (int i = 1; i<m; ++i) {
            work[i][0] = work[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i<n; ++i) {
            work[0][i] = work[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i<m; ++i) {
            for (int j = 1; j<n; ++j) {
                work[i][j] = matrix[i][j]+work[i - 1][j] + work[i][j - 1] - work[i - 1][j - 1];
            }
        }
        int max= Integer.MIN_VALUE;
        for (int a = 0; a < m; a++) {
            for (int b = a; b < m; b++) {
                for (int c = 0; c < n; c++) {
                    for (int d = c; d < n; d++) {
                        int topArea = a == 0 ? 0 : work[a - 1][d];
                        int leftArea = c == 0 ? 0 : work[b][c - 1];
                        int ltArea = (a == 0 || c == 0) ? 0 : work[a - 1][c - 1];
                        int curSum = work[b][d] - leftArea - topArea + ltArea;
                        if (curSum == k)
                            return k;
                        if (curSum<k) max = Math.max(max,curSum);
                    }
                }
            }
        }
        return max;
    }
}





public class AAA {
    public static void main(String[] args) {

    }
}
