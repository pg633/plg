package leetcoder;


import org.w3c.dom.Node;

import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        int  sum = 0;
        Arrays.sort(nums);
        if(nums.length %2==0){
            sum = (nums[nums.length/2]+nums[nums.length/2+1])/2;
        }else{
            sum = nums[nums.length/2];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res+=Math.abs(nums[i]-sum);
        }
        return res;
    }
}



public class AAA {
    public static void main(String[] args) {

    }
}