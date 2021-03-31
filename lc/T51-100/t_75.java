package leetcoder;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int l = 0 ;
        int r = nums.length -1;
        int i = 0;
        while(i<nums.length)
        {

            if(nums[i] == 0){
                swap(nums,l,i);
                l++;
                i++;
            }else if (nums[i] ==1){
                i++;
            }else {
                if(i==r) break;
                swap(nums,i,r);
                r--;
            }
        }
    }
    public void swap(int [] a,int l,int r){
        int k = a[l];
        a[l] = a[r];
        a[r] = k;
    }
}

public class Main{
    public static void main(String[] arg) {

        int [] a = {2,0,2,1,1,0} ;
        new Solution().sortColors(a);




    }



}
