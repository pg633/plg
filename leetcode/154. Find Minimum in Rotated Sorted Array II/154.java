package leetcoder;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        int left =0;
        int right = nums.length-1;
        while(left < right && nums[left]==nums[right]){
            left++;
        }
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid ;
            }
        }
        return nums[left];
    }
}

public class Main {

    public static void main(String[] arg) {
        int i = new Solution().findMin(new int[]{3,3,1,3});
        System.out.println(i);

    }

}