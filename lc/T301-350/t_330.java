package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;

import java.util.List;
import java.util.TreeMap;

class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0;
        int res = 0;
        long  miss = 1;
        while(miss<=n){
            if( i<nums.length && nums[i]<=miss){
                miss+=nums[i];
                ++i;
            }else{
                miss <<=1;
                ++res;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {




    }
}