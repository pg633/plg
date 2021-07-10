package leetcoder;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0  ) return 0;
        int col = matrix[0].length;
        if( col ==0) return 0;
        int [][] dp = new int[row][col];

        int max = 0;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0]=='1'){
                max = 1 ;
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < col; i++) {
            if(matrix[0][i]=='1'){
                max = 1 ;
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] =='1' ){
                    dp[i][j] = 1;
                }
                if(dp[i-1][j-1] >0 && dp[i-1][j] >0&& dp[i][j-1] >0&& dp[i][j] >0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1] ,dp[i-1][j] ) ,  dp[i][j-1] ) +1;
                    max = Math.max(max,dp[i][j] *dp[i][j]);
                }
            }
        }
        return max;
    }
}

public class Main {

    public static void main(String[] arg) {


    }

}