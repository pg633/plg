package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;




class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res =new ArrayList<>();
        if(nums.length==0)return res;
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+1){
                r = i;
            }else {
                if(l==r){
                    res.add(String.valueOf(nums[l]));
                }else {
                    res.add(new StringBuilder().append(nums[l]).append("->").append(nums[r]).toString());
                }
                l=i; r=i;
            }
        }
        if(l==nums.length-1){
            res.add(String.valueOf(nums[l]));
        }else {
            res.add(new StringBuilder().append(nums[l]).append("->").append(nums[nums.length-1]).toString());
        }
        return res;
    }
}

public class Main {

    public static void main(String[] arg) {
        List<String> strings = new leetcoder.Solution().summaryRanges(new int[]{0,2,3,4,6,8,9});
        strings.forEach(System.out::println);
    }

}