package leetcoder;


import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        BitSet b = new BitSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            b.set(nums[i]-1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!b.get(i)) res.add(i+1);
        }
        return res;
    }
}


public class AAA {
    public static void main(String[] args) {
        List<Integer> i = new Solution().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (Integer integer : i) {
            System.out.println(integer);
        }
    }
}
