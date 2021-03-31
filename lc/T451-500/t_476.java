package leetcoder;


import org.w3c.dom.Node;

import java.util.*;

class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='0') chars[i] = '1';
            else chars[i]='0';
        }
        int res =0;
        for (int i = 0; i < chars.length; i++) {
            res = res *2 + chars[i]-'0';
        }
        return res;

    }
}

public class AAA {
    public static void main(String[] args) {

    }
}