package leetcoder;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private int[] v ;
    public Solution(int[] nums) {
        v = Arrays.copyOf(nums,nums.length);
    }
    public int[] reset() {
        return v;
    }
    public int[] shuffle() {
        List<Integer> collect = Arrays.stream(v).boxed().collect(Collectors.toList());
        Collections.shuffle(collect);
        return collect.stream().mapToInt(Integer::valueOf).toArray();
    }
}


public class AAA {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});



    }
}
