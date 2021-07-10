package leetcoder;


import java.util.*;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,s.length()*2-1).indexOf(s)!=-1;
    }
}


public class AAA {
    public static void main(String[] args) {
        boolean aba = new Solution().repeatedSubstringPattern("aba");
        System.out.println(aba);

    }
}