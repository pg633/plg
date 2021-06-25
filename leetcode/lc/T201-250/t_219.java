package leetcoder;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k && j+i<nums.length; j++) {
                if(nums[j+i] == nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}





public class Main {

    public static void main(String[] arg) {


    }

}