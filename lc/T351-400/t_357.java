package leetcoder;

import java.util.*;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int res = 10;
        int t = 9;
        for (int i = 1; i < n; i++) {
            t*=(10-i);
            res+=t;
        }
        return res;
    }
}







public class AAA {
    public static void main(String[] args) {

    }
}
