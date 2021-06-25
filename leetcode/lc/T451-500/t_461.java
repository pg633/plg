package leetcoder;


import java.util.*;



class Solution {
    public int hammingDistance(int x, int y) {
        int t = x^y;
        String s = Integer.toBinaryString(t);
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
}








public class AAA {
    public static void main(String[] args) {
        boolean aba = new Solution().repeatedSubstringPattern("aba");
        System.out.println(aba);

    }
}