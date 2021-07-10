package leetcoder;

import java.util.*;



class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0)return 1;
        int len = nums.length;
        BitSet b = new BitSet(len);
        for(int i = 0 ;i<len;i++){
            if(nums[i] > 0 ){
                b.set(nums[i]);
            }
        }
        for(int i=1;i<len+1;i++){
            if(b.get(i) ){
                return i;
            }
        }
        return -1;
    }
}