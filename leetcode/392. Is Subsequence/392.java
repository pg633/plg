package leetcoder;


import java.util.*;



class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int l = s1.length;
        int r = s2.length;
        int num1 = 0;
        int num2 = 0;
        while(num1 <l &&  num2 <r){
            if(s1[num1] == s2[num2])
            {
                num2++;
                num1++;
            }else{
                num2++;
            }
        }
        if(num1 == l && num2 <= r){
            return true;
        }
        return false;
    }
}






public class AAA {
    public static void main(String[] args) {


    }
}
