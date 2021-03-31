package leetcoder;


import java.util.*;


class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] next = nextGreaterElement(nums2);
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            m.put(nums2[i],i);
        }
        int []res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = next[m.get(nums1[i])];
        }
        return res;

    }

    private int[] nextGreaterElement(int[] nums2) {
        int n = nums2.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        Stack<Integer> s=  new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && nums2[i] > nums2[s.peek()])
                dp[s.pop()] = nums2[i];
            s.push(i);
        }
        return dp;
    }
}





public class AAA {
    public static void main(String[] args) {

        int[] ints = new Solution().nextGreaterElement(new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}