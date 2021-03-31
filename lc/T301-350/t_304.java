package leetcoder;


import java.util.*;
class NumMatrix {
    int[][] dp ;
    public NumMatrix(int[][] matrix) {
        if(matrix == null)return;
        int row = matrix.length;
        if(row ==0 )return;
        int col = matrix[0].length;
        if(col ==0)return;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0) dp[i][j] = matrix[i][j];
                else if(i==0) dp[i][j] = dp[i][j-1] + matrix[i][j];
                else if(j==0) dp[i][j] = dp[i-1][j] + matrix[i][j];
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 > row2) return sumRegion(row2,col1, row1,col2);
        if(col1 > col2) return sumRegion(row1,col2,row2, col1);

        return dp[row2][col2] +  (row1 > 0 && col1 >0 ? dp[row1-1][col1-1]:0 ) -   (row1 > 0 ? dp[row1-1][col2]:0) - ( col1 >0 ?dp[row2][col1-1]:0);
    }
}


public class Main {

    public static void main(String[] arg) {
        int [][] a = new int [10][10];
        for (int[] ints : a) {
            Arrays.fill(ints,1);
        }
        leetcoder.NumMatrix numMatrix = new leetcoder.NumMatrix(a);
    }

}

