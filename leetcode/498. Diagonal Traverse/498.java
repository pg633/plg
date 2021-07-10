package leetcoder;


import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length==0)return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;
        int [] dp = new int[n*m];
        int r = 0;
        int c = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = matrix[r][c];
            // 层数
            if((r+c) %2==0){
                if(c==m-1){
                    r++;
                }else if(r==0){
                    c++;
                }else{
                    r--;
                    c++;
                }

            }else {
                if(r==n-1){
                    c++;
                }else if(c==0){
                    r++;
                }else {
                    r++;
                    c--;
                }
            }
        }
        return dp;
    }
}



public class AAA {
    public static void main(String[] args) {
        String[] res = new String[]{ "Hello", "Alaska", "Dad", "Peace"};

        String[] words = new Solution().findWords(res);
        for (String word : words) {
            System.out.println(word);
        }


    }
}