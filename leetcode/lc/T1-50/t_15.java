package  leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        int len = nums.length;
        if(len<3) return res;
        Arrays.sort(nums);
        final int target =0;
        for(int i=0;i<len-2;i++)
        {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = len-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]<target)
                {
                    ++j;
                    while(nums[j]==nums[j-1] && j<k)++j;
                }
                else if(nums[i]+nums[j]+nums[k]>target)
                {
                    --k;
                    while(nums[k]==nums[k+1] && j<k)--k;
                }
                else
                {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    ++j;
                    --k;
                    while(nums[j]==nums[j-1] && j<k)++j;
                    while(nums[k]==nums[k+1] && j<k)--k;
                }
            }
        }
        return res;
    }
}