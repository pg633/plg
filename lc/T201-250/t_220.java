package leetcoder;


import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // nums [i] - nums[j]  == t  i-j == k
        if(k<=0) return false;
        int len = nums.length;
        int l = 0;
        int r = 1;
        while(l<len-1){
            if(l!=r &&Math.abs((long)nums[l]-nums[r]) <= t){
                return true;
            }
            if(r -l ==k || len-1==r){
                l++;
                if(t!=0){
                    r = l+1;
                }
            }else{
                r++;
            }
        }
        return false;
    }
}




public class Main {

    public static void main(String[] arg) {
        boolean b = new leetcoder.Solution().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}
                , 2
                , 3);
        System.out.println(b);

    }

}