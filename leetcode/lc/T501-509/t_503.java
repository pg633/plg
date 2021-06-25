package leetcoder;


import java.util.*;


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []res = new int[nums.length];
        Map<Integer,Integer> m = new HashMap();
        int [] dp = new int[nums.length*2];
        Stack<Integer> s=  new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            dp[i+nums.length] = dp[i] = nums[i];
        }

        for (int i = 0; i < dp.length; i++) {
            while (!s.isEmpty() && dp[i] > dp[s.peek()])
                m.put(s.pop(),dp[i]);
            s.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(i)) res[i] = m.get(i);
            else res[i] = -1;
        }
        return res;

    }
}





public class AAA {
    public static void main(String[] args) {



    }
}