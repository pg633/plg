package leecoder;


import leetcoder.Interval;

import java.util.TreeMap;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length==0) return 0;
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for(int i=1; i<nums.length; i++) sums[i] = sums[i-1] + nums[i];
        TreeMap<Long, Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(lower <= sums[i] && sums[i] <= upper) count ++;
            for (Integer value : map.subMap(sums[i] - upper, true, sums[i] - lower, true).values()) {
                count += value;
            }
            Integer integer = map.get(sums[i]);
            if(integer == null) integer =1 ;else integer ++;
            map.put(sums[i],integer);
        }
        return count;
    }
}




public class Main {
    public static void main(String[] args) {
        System.out.println(new leecoder.Solution().countRangeSum(new int[]{
                2147483647,-2147483648,-1,0

        }, -1, 0));

    }
}