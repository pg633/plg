package leetcoder;


import java.util.*;


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums,S,0,0);
    }

    private int dfs(int[] nums, int s, int pos, int sum) {
        int res = 0;
        if(nums.length == pos){
            res += sum == s ? 1:0;
            return res;
        }
        res += dfs(nums,s,pos+1,sum+nums[pos]);
        res += dfs(nums,s,pos+1,sum-nums[pos]);
        return res;
    }
}




public class AAA {
    public static void main(String[] args) {

        int[] ints = new Solution().nextGreaterElement(new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}