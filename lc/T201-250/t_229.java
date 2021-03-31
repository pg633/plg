package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int x : nums) {
            if (n1 == x && c1 >0) {
                c1++;
            } else if (n2 == x&& c2 >0) {
                c2++;
            } else if (c1 == 0) {
                n1 = x;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = x;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if (n1 == x) {
                c1++;
            } else if (n2 == x) {
                c2++;
            }
        }
        if (  c1 > nums.length / 3)res.add(n1);
        if ( n2 != n1 && c2 > nums.length / 3)res.add(n2);
        return res;
    }
}
public class Main {

    public static void main(String[] arg) {
        List<Integer> strings = new leetcoder.Solution().majorityElement(new int[]{3,2,3});
        strings.forEach(System.out::println);
    }

}