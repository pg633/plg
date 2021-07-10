package leetcoder;


class Solution{
    public void nextPermutation(int[] nums){
        if(nums == null ||nums.length==0) return;
        if(nums.length ==1 )return;
        int p = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                p = i;break;
            }
        }
        if(p==-1){
            reverse(nums,0,nums.length-1);
            return ;
        }

        int q = nums.length -1;
        while(nums[q]<=nums[p]){
            q--;
        }
        swap(nums,p,q);
        reverse(nums,p+1,nums.length-1);
    }
    public void reverse(int[]arr,int from,int to){
        if(from>= to) return;
        while(from<to){
            swap(arr,from,to);
            ++from;
            --to;
        }
    }
    public void swap(int[]arr,int i,int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

}