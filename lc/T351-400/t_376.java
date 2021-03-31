package leetcoder;


import java.util.*;



class Solution {
    public int wiggleMaxLength(int[] nums) {
        int [] dp1 = new int[nums.length];
        int [] dp2 = new int[nums.length];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        int max = 0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp1[i] = Math.max(dp1[i], 1 + dp2[j]);
                else if (nums[i] < nums[j])
                    dp2[i] = Math.max(dp2[i], 1 + dp1[j]);
            }
            max = Math.max(max, Math.max(dp1[i],dp2[i]));
        }
        return max;

    }
}





public class AAA {
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));

    }
}
