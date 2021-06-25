package leetcoder;


import java.util.*;
class Solution {
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = t.length();
        int i =0 ;
        for (  i = 0; i < s.length(); i++) {
            if(t.substring(i,n).equals(s.substring(0,n-i))){
                break;
            }
        }

        return t+s.substring(n-i,n);
    }
}





public class Main {

    public static void main(String[] arg) {
        String aacecaaa = new leetcoder.Solution().shortestPalindrome("aacecaaa");
        System.out.println(aacecaaa);
    }

}