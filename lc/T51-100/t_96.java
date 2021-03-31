package leetcoder;


import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
class Solution {
    public int numTrees(int n) {
        if(n==0) return 0;
        int [] dp = new int [n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }
    public int  catlan(int n) {
        return cal(n,2*n)/(n+1);

    }
    private int cal(int n,int m){
        BigInteger ans =   BigInteger.valueOf(1) ;
        int j= 1;
        for(int i=n+1;i<=m;i++){
            ans = ans.multiply( BigInteger.valueOf(i));
            if(ans.mod(BigInteger.valueOf(j)).compareTo(BigInteger.valueOf(0)) ==0  && j<=n){
                ans = ans.divide(BigInteger.valueOf(j));
                j++;
            }

        }
        return Integer.valueOf(ans.toString());
    }
}


class Main {

    public static void main(String[] arg) {


        Object ob = new leetcoder.Solution().catlan(3);

        System.out.println(ob  );


    }
}