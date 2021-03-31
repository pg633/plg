package leetcoder;

import java.io.IOException;

class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null) return false;
        int lena = s.length();
        int lenb = p.length();
        boolean [][]dp = new boolean[lena+1][lenb+1];
        dp[0][0]=true;
        for(int i=0;i<lenb;i++){
            if(p.charAt(i)=='*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i=0;i<lena;i++)
            for(int j=0;j<lenb;j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j)=='*'){
                    if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.'){
                        dp[i+1][j+1] =dp[i+1][j-1];
                    }else {
                        dp[i+1][j+1] = (dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1]);
                    }
                }
            }

        return dp[lena][lenb];
    }
}


