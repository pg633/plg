package leetcoder;


import java.util.*;




class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res= 0;
        int t = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            res+= nums[i]- nums[0];
        }
        return res;
    }
}



public class AAA {
    public static void main(String[] args) {


    }
}