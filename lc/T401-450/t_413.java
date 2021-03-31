package leetcoder;


import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int d1 = A[1] - A[0];
        int res = 0;
        int dp = 0;
        for (int i = 2; i < A.length; i++) {
            int d2 = A[i] - A[i-1];
            if(d2 == d1) res += (++dp);
            else dp = 0;
            d1 = d2;
        }
        return res;
    }
}

public class AAA {
    public static void main(String[] args) {

        int i = new Solution().numberOfArithmeticSlices(new int[]{1, 1, 2, 5, 7});
        System.out.println(i);

    }
}
