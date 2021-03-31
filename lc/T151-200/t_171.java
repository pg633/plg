package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int k  = c - 'A' + 1;
            n*=26;
            n+=k;
        }
        return n;

    }
}

public class Main {

    public static void main(String[] arg){

        int a = new Solution().titleToNumber("AB");
        System.out.println(a);


    }

}