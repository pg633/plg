package leetcoder;

import java.util.*;




class Solution {
    private final int mod = 1337;
    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            res =   (pow(res,10) * pow(a,b[i]) % mod);
        }
        return res;
    }

    private int pow(int res, int i) {
        if(i==0) return 1;
        else if(i==1) return res %mod;
        else return pow(res %mod,i/2) * pow(res%mod,i-i/2) %mod;

    }
}


public class AAA {
    public static void main(String[] args) {
        int i = new Solution().superPow(2, new int[]{1, 0});
        System.out.println(i);

    }
}
