package leetcoder;


import java.util.*;

class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);
    }

    private int merge(int[] nums, int l, int r) {
        if(l>=r) return 0;
        int mid = l+(r-l)/2;
        int count = merge(nums,l,mid) + merge(nums,mid+1,r);
        int idx1 = l ,idx2 = mid+1;
        while (idx1 <= mid && idx2 <=r){
            while (idx2<=r && nums[idx1] > 2L*nums[idx2]) idx2++;
            count+=idx2 - mid-1;
            idx1++;
            if(idx2 > r && idx1<=mid) count+= (mid - idx1+1) *(idx2 -mid-1);
        }
        merge(nums,l,mid,r);
        return count;
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int []t= new int[r-l+1];
        int idx = 0,l1 = l,l2 = mid+1;
        while (l1 <= mid && l2 <= r) t[idx++] = nums[l1] < nums[l2]?nums[l1++]:nums[l2++];
        while (l1<=mid) t[idx++] = nums[l1++];
        while(l2<=r) t[idx++] = nums[l2++];
        for (int i = 0; i < idx; i++) {
            nums[l+i] = t[i];
        }
    }
}



public class AAA {
    public static void main(String[] args) {


    }
}