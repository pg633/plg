package  leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null|| nums.length<4) return res;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            if(i>0&&nums[i] == nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++)
            {
                if(j>i+1 && nums[j]== nums[j-1])continue;
                int p = j+1;
                int q=nums.length-1;
                while(p<q)
                {
                    int sum = nums[i]+nums[j]+nums[p]+nums[q];
                    if(sum == target ){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[p]);
                        tmp.add(nums[q]);
                        res.add(tmp);
                        while(p<q &&nums[p]==nums[p+1])++p;
                        while(p<q&&nums[q]==nums[q-1])--q;
                        ++p;--q;
                    }else if(sum<target) {
                        p++;
                    }
                    else{
                        q--;
                    }
                }
            }
        }
        return res;
    }
}
