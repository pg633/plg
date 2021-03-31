package leetcoder;


import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0 ;
        int r =nums.length-1;
        int t = target;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == t){
                return  true;
            }else if(nums[mid] > nums[r]){
                if(nums[mid] > t && nums[l] <= t  ){
                    r =mid -1;
                }else {
                    l = mid +1;
                }
            }else if(nums[mid] < nums[r]){
                if(nums[mid] < t   && nums[r] >= t){
                    l = mid +1;
                }else {
                    r = mid -1;
                }
            }else{
                r--;
            }
        }
        return false;
    }
}


public class Main {
    public static void main(String[] arg) {
        int []  a ={5,1,3};
        System.out.println( new leetcoder.Solution().search(a,5) );



    }


}

