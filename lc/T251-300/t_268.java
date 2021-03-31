package leetcoder;

import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        long res = 0;
        for (int num : nums) {
            res += num;
        }
        return (int) ((nums.length *( nums.length+1))/2 - res);
    }
}


public class Main {

    public static void main(String[] arg) {
        int i = new leetcoder.Solution().missingNumber(new int[]{3,0,1});
        System.out.println(i);

    }

}

