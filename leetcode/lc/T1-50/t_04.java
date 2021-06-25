package leetcoder;

import java.awt.SystemTray;

class Solution {

    public   double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1  = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        int k1 = len+1>>1;
        int k2 = len+2>>1;
        getKMin(nums1,0,nums2,0,k2);
//        System.out.println(k1+"   "+k2);
//        System.out.println(getKMin(nums1,0,nums2,0,k1)+"   "+getKMin(nums1,0,nums2,0,k2));
        return   (getKMin(nums1,0,nums2,0,k1)+getKMin(nums1,0,nums2,0,k2))*1.0/2;
    }

    public    int getKMin(int[] nums1,int l,int[]nums2,int r,int k){
        if(l>nums1.length-1) return nums2[r+k-1];
        if(r>nums2.length-1) return nums1[l+k-1];
        if(k==1) return Math.min(nums1[l],nums2[r]);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if(l+k/2-1 < nums1.length){
            a = nums1[l+k/2-1];
        }
        if(r+k/2-1 < nums2.length){
            b = nums2[r+k/2-1];
        }
        return a<b?getKMin(nums1,l+k/2,nums2,r,k-k/2):getKMin(nums1,l,nums2,r+k/2,k-k/2);
    }
}


public class t_04 {
    public static void main(String []arg){
        leetcoder.Solution s = new leetcoder.Solution();
        int [] num1 = {1,2};
        int [] num2 = {-1,3};
        System.out.println(s.findMedianSortedArrays(num1,num2));
    }
}
