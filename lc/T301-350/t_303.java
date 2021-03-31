package leetcoder;


import java.util.*;

class NumArray {
    int []dp ;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (i-1>=0?dp[i-1]:0) + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return dp[j]- (i-1>=0?dp[i-1]:0);
    }
}



public class Main {

    public static void main(String[] arg) {
        leetcoder.NumArray numArray = new leetcoder.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    }

}

