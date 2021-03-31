package leetcoder;


import java.sql.Array;
import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if(n==0) return list ;
        int []dp =  new int[n];

        dfs(list,dp,n,0);
        return list;
    }
    void dfs(List<List<String>> list, int []dp,int n,int now ){
        for(int i=0;i<n;i++) {
            if (f(dp, n, now, i)) {
                dp[now] = i;
                if (now == n - 1) {
                    add1(list, dp);
                    dp[now] = 0;
                    return;
                }
                dfs(list, dp, n, now + 1);
                dp[now] = 0;
            }
        }
    }
    void  add1(List<List<String>>  l,int []b ){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<b.length;i++){
            StringBuffer sf = new StringBuffer();
            for(int j=0;j<b.length;j++){
                if(j==b[i]) {
                    sf.append('Q');
                }
                else sf.append('.');
            }
            ans.add(sf.toString());
        }
        l.add(ans);

    }
    boolean f(int [] dp,int n ,int row ,int col){
        for(int i=0;i<row;i++){
            if(dp[i] == col || dp[i]+i == row+col || dp[i]-i==col-row)
                return false;
        }
        return true;

    }
}


