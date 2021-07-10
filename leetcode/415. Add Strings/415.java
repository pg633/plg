package leetcoder;

import java.lang.reflect.Array;
import java.util.*;



class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(n,m); i++) {
            int k1 = 0;
            int k2 = 0;
            if(i<n){
                k1 = num1.charAt(n -1-i) - '0';
            }
            if(i<m){
                k2 = num2.charAt(m-1-i) - '0';
            }
            int k = k1+k2+last;
            last = k /10;
            k%=10;
            System.out.println(k);
            sb.append((char)(k+'0'));
        }
        if(last!=0) sb.append((char)(last+'0'));
        return sb.reverse().toString();
    }
}
public class AAA {
    public static void main(String[] args) {

        String s = new Solution().addStrings("123", "337");
        System.out.println(s);
        System.out.println(1+'a');
    }
}
