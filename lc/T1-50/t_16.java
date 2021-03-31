class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        int len = nums.length-2;
        for(int i=0;i<len;i++)
        {
            int j= i+1;
            int k = nums.length-1;
            while(j<k){
                int dd = nums[i]+nums[j]+nums[k];
                int diff_target = Math.abs(dd - target);
                if(diff > diff_target)
                {
                    diff= diff_target;
                    sum = dd;
                }
                if(dd<target) ++j;
                else if(dd>target) --k;
                else return target;
            }
        }
        return sum;
    }
}