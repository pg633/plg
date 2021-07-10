package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;

import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
class Solution {
    public boolean isValidSerialization(String preorder) {
        int res = 1;
        String[] split = preorder.split(",");
        for (String s : split) {
            if(res == 0) return false;
            if(s.charAt(0)=='#') res--;
            else res++;
        }
        return res ==0;

    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new leecoder.Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));


    }
}