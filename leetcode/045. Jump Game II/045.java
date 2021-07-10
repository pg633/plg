
class Solution {
    public int jump(int[] nums) {
        if(nums==null|| nums.length<2)return 0;
        int len = nums.length;
        int p = 0;
        int index= 0;
        int  step = 0;
        while(p < nums.length){
            if(p+nums[p] >= nums.length-1){
                return step+1;
            }
            int _max =0;
            for(int i=p+1;i<=p+nums[p];i++){
                if(_max < i+nums[i]){
                    _max = i+nums[i];
                    index = i;
                }
            }
            step++;
            p= index;
        }
        return step;
    }
}