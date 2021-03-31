package leetcoder;

import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i]-nums[i-1],res);
        }
        return res;
    }
}





public class Main {

    public static void main(String[] arg) {


    }

}