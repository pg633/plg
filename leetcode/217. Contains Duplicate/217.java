package leetcoder;


import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return collect.size() != nums.length;
    }
}









public class Main {

    public static void main(String[] arg) {
        List<List<Integer>> lists = new leetcoder.Solution().combinationSum3(3, 7);
        for (List<Integer> lis :lists){
            lists.forEach(System.out::print);
            System.out.println();
        }
    }

}