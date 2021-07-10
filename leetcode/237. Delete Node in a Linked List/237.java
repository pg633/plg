package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int k =1;
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            k *=nums[i-1];
            dp[i] = k;
        }
        k =1;
        for (int i = nums.length-2 ;i >=0; i--) {
            k*=nums[i+1];
            dp[i]*=k;
        }
        return dp;
    }
}

public class Main {

    public static void main(String[] arg) {

        int[] ints = new leetcoder.Solution().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));

    }

}