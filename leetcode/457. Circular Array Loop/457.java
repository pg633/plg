

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length <2) return false;
        int n = nums.length;
        boolean flag = nums[0] >0;
        int step =(n + nums[0] + 0) % n;
        int newStep = 0;
        while(true){
            if(step ==0) return true;
            else if(nums[step]==0) return false;
            newStep = (n + nums[step] + step) % n;
            if(nums[newStep] > 0 &&flag == false) return false;
            else if(nums[newStep] < 0 && flag==true) return false;
            nums[step] = 0;
            step = newStep;
        }
    }
}

