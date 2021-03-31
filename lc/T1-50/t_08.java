package leetcoder;

import java.io.IOException;

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()) return 0;
        int sign = 1;
        int res = 0;

        int len = str.length();
        int index = 0;
        if(str.charAt(index) =='-'){
            index++;
            sign = -1;
        }else if(str.charAt(index) =='+'){
            index++;
            sign = 1;
        }

        while(index<len && str.charAt(index)>='0'&& str.charAt(index) <='9'){
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 &&str.charAt(index) -'0'>7))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10+str.charAt(index)-'0';
            index++;
        }
        return sign*res;
    }
}

