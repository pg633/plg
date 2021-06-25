package leetcoder;

import javax.xml.transform.SourceLocator;
import java.util.*;

class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int [][] dp = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[1][i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[1][i-1],dp[0][i-1]);
            dp[1][i] = dp[0][i-1] + dp[1][i];
        }
        return Math.max(dp[0][nums.length-1],dp[1][nums.length-1]);
    }
}
public class Main {

    public static void main(String[] arg) {
        int rob = new Solution().rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);;
    }

}