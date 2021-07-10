package leetcoder;

import java.util.*;


class Solution {
    public boolean canMeasureWater(int x, int y, int z) {

        int k = gcd(x,y);
        if(z==0) return true;
        if(k==0) return false;
        if(x+y >= z)
            return z % k ==0;
        else return false;
    }

    private int gcd(int x, int y) {
        return (y>0)?gcd(y,x%y):x;
    }
}




public class AAA {
    public static void main(String[] args) {
        new Solution().canMeasureWater(3,5,4);
    }
}
