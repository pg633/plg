package leetcoder;


import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int []dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if(i+num <= target){
                    dp[i+num] += dp[i];
                }
            }
        }
        return dp[target];
    }
}



public class AAA {
    public static void main(String[] args) {

        int i = new Solution().combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);

    }
}
