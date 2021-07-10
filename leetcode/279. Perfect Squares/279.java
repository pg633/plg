package leetcoder;

import java.util.*;


class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 0; i*i <=n ; i++) {
            dp[i*i] =1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i+j*j <=n ; j++) {
                dp[i+j*j] = Math.min(dp[i+j*j],dp[i]+1);
            }
        }
        return dp[n];
    }
}



public class Main {

    public static void main(String[] arg) {
        int i = new leetcoder.Solution().numSquares(13);
        System.out.println(i);

    }

}

