package leetcoder;


import org.w3c.dom.Node;

import java.util.*;


class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p.length() ==0) return 0;
        char[] chars = p.toCharArray();
        int []count = new int[26];
        int ret = 0;
        int curCount =1;
        for (int i = 0; i < chars.length; i++) {
            if(i>0&&(chars[i]-chars[i-1] ==1||chars[i-1]-chars[i]==25)){
                curCount++;
            }else{
                curCount=1;
            }
            count[chars[i]-'a' ]= Math.max(count[chars[i]-'a' ],curCount);
        }
        for (int i : count) {
            ret+=i;
        }
        return ret;
    }
}

public class AAA {
    public static void main(String[] args) {

    }
}