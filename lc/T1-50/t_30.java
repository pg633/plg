package leetcoder;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public void nextPermutation(int[] nums) {
      int len = nums.length;
      int k =-1;
      int l = 0;
      int i =0;

      for(i=len-2;i>=0;i--){
          if(nums[i]<nums[i+1]){
              k = i;
              break;
          }
      }
      if(k==-1){
          Arrays.sort(nums,Comparator.comparing(int l,int r){return l<r?-1:1;});
      }



    }
    public void swap(int []arr,int i,int j){
        int k = arr[i];
        arr[i]=arr[j];
        arr[j] = k;
    }
}
