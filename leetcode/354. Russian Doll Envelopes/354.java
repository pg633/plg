package leetcoder;

import java.util.*;




class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n<2) return n;
        int max = 1;
        int []dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[j][0] < envelopes[i][0] &&
                        envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

public class AAA {
    public static void main(String[] args) {

    }
}
