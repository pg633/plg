package leetcoder;


import java.util.*;

class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0;long r = 0;
        for (int i = 0; i < nums.length; i++) {
            r+=nums[i];
        }
        if(m==1) return (int)r;
        long ans = 0;
        while (l<=r){
            long mid = (l+r)/2;
            if(ok(mid,nums,m)){
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return (int)ans;
    }

    private boolean ok(long mid, int[] nums, int m) {
        int last =  0;
        for (int i = 0; i < nums.length; i++) {
            last+=nums[i];
            if(nums[i]>mid) return false;
            if(last> mid){
                last = 0;
                i--;
                m--;
            }else if(last == mid){
                m--;
                last=0;
            }
        }
        if(last>mid) return false;
        if(last >0) m--;
        return m>=0;
    }
}

public class AAA {
    public static void main(String[] args) {
        int i = new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        System.out.println(i);
    }
}
