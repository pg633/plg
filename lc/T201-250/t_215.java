package leetcoder;


import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}


public class Main {

    public static void main(String[] arg) {

    }

}