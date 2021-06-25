package leetcoder;


import java.util.*;


class Solution {
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        int res= 0;
        for (Character character : m.keySet()) {
            Integer integer = m.get(character);
            res += integer/2*2;
        }
        if(res < s.length()) res++;
        return res;


    }
}




public class AAA {
    public static void main(String[] args) {
        int abccccdd = new Solution().longestPalindrome("abccccdd");
        System.out.println(abccccdd);


    }
}
