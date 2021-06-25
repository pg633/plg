package leetcoder;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max =0;
        int cur = 0;
        for (int i = 31; i >= 0; i--) {
            cur = cur| 1<<i ;
            Set<Integer> s = new HashSet<>();
            for (int num : nums) {
                s.add(num & cur);
            }
            int tmp = max | 1<<i;
            for (Integer prefix  : s) {
                if(s.contains(prefix ^ tmp)){
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}


public class AAA {
    public static void main(String[] args) {
        int cur =2;
        cur = cur|1<<1+1;
        System.out.println(cur);

    }
}
