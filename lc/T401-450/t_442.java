package leetcoder;


import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            while (nums[i] != -1 && nums[i] != nums[nums[i] - 1]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
            if (nums[i] != -1 && nums[i] != i + 1 && nums[i] == nums[nums[i]-1]) {
                res.add(nums[i]);
                nums[i] = -1;
            }
        }
        return res;
    }
}

public class AAA {
    public static void main(String[] args) {
        List<Integer> duplicates = new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (Integer duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }
}