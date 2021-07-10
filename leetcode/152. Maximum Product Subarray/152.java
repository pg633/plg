package leetcoder;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;



class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int [] max = new int[nums.length];
        int [] min = new int[nums.length];
        max[0] = min [0] =nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
            min[i] = Math.min(Math.min(nums[i],nums[i]*max[i-1]),nums[i]*min[i-1]);
        }
        int res = max[0];
        for (int i = 0; i < max.length; i++) {
            res = Math.max(res,max[i]);
        }
        return res;
    }
}


public class Main {

    public static void main(String[] arg) {
        int i = new Solution().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);

    }

}