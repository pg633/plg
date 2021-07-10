package leecoder;

import leetcoder.ListNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int [] dp = new int[n];
        dp[0] = 1;
        int [] xi = new int[primes.length];
        Arrays.fill(xi,0);
        for (int i = 1; i <n; i++) {
            int min = Integer.MAX_VALUE;
            int min_id = -1;
            for (int j = 0; j < primes.length; j++) {
                if(min> dp[xi[j]] * primes[j] ){
                    min = dp[xi[j]] * primes[j];
                    min_id = j;
                }
            }
            if(dp[i-1] ==min){
                i--;
                xi[min_id]++;
                continue;
            }else{
                xi[min_id]++;
                dp[i] = min;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}




public class Main {
    public static void main(String[] args) {
        int i = new leecoder.Solution().nthSuperUglyNumber(12,new int[]{2,7,13,19});
        System.out.println(i);
    }
}