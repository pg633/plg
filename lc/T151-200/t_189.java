package leetcoder;

import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }

    private void reverse(int[] nums, int l, int r) {
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp ;
            l++;
            r--;
        }
    }
}




public class Main {

    public static void main(String[] arg) {


    }

}