package leetcoder;


import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] dp;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal > maxChoosableInteger*(1l+maxChoosableInteger)/2)
            return false;
        dp = new int[1<<maxChoosableInteger];
        return dfs(maxChoosableInteger,desiredTotal,0,0);
    }

    private boolean dfs(int n, int des, int dis, int sum) {
        if(dp[dis]!=0)
            return true;
        for (int i = n; i > 0; i--) {
            int mask = (1<<(i-1));
            if( (dis & mask) != 0 ) continue;
            if(sum+i >=des || !dfs(n,des,dis|mask,sum+i)){
                dp[dis] =1 ;
                return true;
            }
        }
        dp[dis] = 0;
        return false;
    }
}



public class AAA {
    public static void main(String[] args) {
        boolean b = new Solution().canIWin(10, 11);
        System.out.println(b);
    }
}