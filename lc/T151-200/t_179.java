package leetcoder;

import java.util.Arrays;
import java.util.Comparator;



class Solution {

    public String largestNumber(int[] ss) {

        String[]nums = new String[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = String.valueOf(ss[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        });
        if(nums[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}





public class Main {

    public static void main(String[] arg) {
        int[] a = new int[]{
                10, 2, 9
        };
        String s = new Solution().largestNumber(a);
        System.out.println(s);

    }

}