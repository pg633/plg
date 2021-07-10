package leecoder;

import leetcoder.ListNode;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int []no = new int[n+2];
        for (int i = 0; i < n; i++) {
            no[i+1] = nums[i];
        }
        no[0] = no[n+1] = 1;
        int [][] dp = new int[n+2][n+2];
        // k 1-n
        // i+k 1-n+1
        // j = i+ k -1  // j 0-n
        //dp[i][j] = dp[i][x-1] + dp[x+1][j] + no***;

        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <=n-k+1 ; i++) {
                int j = i+k-1;
                for (int x = i; x <=j ; x++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][x-1]+dp[x+1][j] + no[i-1]*no[x]*no[j+1]);
                }

            }
        }
        return dp[1][n];

    }
}


public class Main {
    public static void main(String[] args) {
        int i = new leecoder.Solution().maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
}