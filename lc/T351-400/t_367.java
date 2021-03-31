package leetcoder;

import java.util.*;


class Solution {
    public boolean isPerfectSquare(int num) {
        int res = 0;
        for (int i = 0; i < 46340; i++) {
            res += 2*i+1;
            if(res == num) return true;
            else if (res > num) break;
        }
        return false;
    }
}




public class AAA {
    public static void main(String[] args) {
        System.out.println( Math.sqrt(Integer.MAX_VALUE)  );



    }
}
