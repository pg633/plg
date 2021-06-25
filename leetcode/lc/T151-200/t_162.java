package leetcoder;


class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int m  = (l+r)/2;
            if(nums[m] > nums[m+1] ){
                r = m ;
            }else {
                l = m+1;
            }
        }
        return nums[l];

    }
}







public class Main {

    public static void main(String[] arg) {
        int peakElement = new Solution().findPeakElement(new int[]{3, 1});
        System.out.println(peakElement);

    }

}