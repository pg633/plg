package leetcoder;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


class Solution {
    public int maxRotateFunction(int[] A) {
        long sum = 0;
        long res = 0;
        long  max = Long.MIN_VALUE ;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            res += A[i] * i;
            sum += A[i];
        }
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max , (res = res + n*A[i] - sum));
        }
        return  (int)max;
    }
}




public class AAA {
    public static void main(String[] args) {

        int i = new Solution().maxRotateFunction(new int[]{4, 3, 2, 6});
        System.out.println(i);


    }
}
