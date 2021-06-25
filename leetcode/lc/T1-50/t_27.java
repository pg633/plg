package  leetcoder;

import java.util.Stack;


class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val ){
                s.push(i);
            }
        }
        int len  = nums.length;
        while(!s.empty()){
            for(int i=s.pop()+1;i<len ;i++){
                nums[i-1] = nums[i];
            }
            len--;
        }
        return len;
    }
}
