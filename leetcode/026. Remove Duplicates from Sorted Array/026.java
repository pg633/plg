package  leetcoder;


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return   0;
        if(nums.length ==1 )return 1;
        int k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1])
                nums[++k] = nums[i];
        }
        return k+1;
    }
}