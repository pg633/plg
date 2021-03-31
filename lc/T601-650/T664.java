class Solution {
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        if(c.length == 0 )return 0;
        int [][] dp = new int[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            dp[i][i] =1 ;
        }

        for (int i = c.length-2; i >=0 ; i--) {
            for (int j = i+1; j < c.length ; j++) {
                dp[i][j] = dp[i+1][j]+1;
                for (int k = i+1; k < j ; k++) {
                    if(c[k] == c[i]){
                        dp[i][j] = Math.min(dp[i][j],dp[i+1][k]+dp[k+1][j]);
                    }
                }
                if(c[i] == c[j]){
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j]);
                }
            }
        }
        return dp[0][c.length-1];

    }
}