package leetcoder;


import java.util.*;



class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        dfs(res,nums,new ArrayList<Integer>(),0);
        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, int[] nums, ArrayList<Integer> integers, int pos) {

        if( integers.size() >=2 ) {
            res.add(new ArrayList<>(integers));
        }
        if(pos == nums.length) return;;
        for (int i = pos; i < nums.length ; i++) {
            if(integers.size() ==0 || nums[i] >= integers.get(integers.size()-1)){
                integers.add(nums[i]);
                dfs(res,nums,integers,i+1);
                integers.remove(integers.size()-1);
            }
        }

    }
}

public class AAA {
    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Solution().findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence.toString());
        }

    }
}