package leetcoder;

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length==0) return new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> []dp =  new  ArrayList [nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);;
        }
        int resId = 0;
        int maxId = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            int id  = 0 ;
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    flag = true;
                    if (max < dp[j].size()) {
                        max = dp[j].size();
                        id = j;
                    }
                }
            }

            if(flag){
                for (int j = 0; j < dp[id].size(); j++) {
                    dp[i].add(dp[id].get(j));
                }
            }
            if(dp[i].size() > maxId){
                maxId = dp[i].size();
                resId = i;
            }
        }
        Collections.sort(dp[resId]);
        return dp[resId];
    }
}


public class AAA {
    public static void main(String[] args) {
        List<Integer> list = new Solution().largestDivisibleSubset(new int[]{1, 2, 3});
        list.forEach(System.out::println);

    }
}
