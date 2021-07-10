package leetcoder;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


class Solution {
    private Map<Integer,List<Integer>> m = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i]))  m.put(nums[i],new ArrayList<>());
            m.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        return m.get(target).get(new Random().nextInt(m.get(target).size()));
    }
}




public class AAA {
    public static void main(String[] args) {


    }
}
