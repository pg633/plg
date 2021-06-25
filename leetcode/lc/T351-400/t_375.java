package leetcoder;


import java.util.*;
class Solution {
    public int getMoneyAmount(int n) {
        int [][]dp = new int[n+1][n+1];

        for (int i = 2; i <=n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(j==i-1){
                    dp[j][i] = j;
                    continue;
                }
                int localMax = Integer.MAX_VALUE;
                for (int k = j+1; k < i; k++) {
                    int max = k + Math.max(dp[j][k-1],dp[k+1][i]);
                    localMax = Math.min(max,localMax);
                }
                dp[j][i] = localMax;
            }
        }
        return dp[1][n];
    }
}


public class AAA {
    public static void main(String[] args) {
        int moneyAmount = new Solution().getMoneyAmount(4);
        System.out.println(moneyAmount);


    }
}
