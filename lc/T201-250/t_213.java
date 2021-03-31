package leetcoder;


import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len ==0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);

        return  Math.max(rob(nums,0,len-2),rob(nums,1,len-1));
    }
    private int rob(int []nums,int l,int r){
        int len = r-l;
        int [][]dp = new int[2][len+1];
        dp[1][0] = nums[l];
        for (int i = 1; i <= len; i++) {
            dp[0][i] = Math.max(dp[1][i-1],dp[0][i-1]) ;
            dp[1][i] = dp[0][i-1] + nums[l+i];
        }
        return Math.max(dp[0][len],dp[1][len]);
    }
}





public class Main {

    public static void main(String[] arg) {
        int [] num = new int[]{1,2,3,1};
        int rob = new leetcoder.Solution().rob(num);
        System.out.println(rob);;

    }

}