
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]dp = new int[m+1][n+1];
        int n1 = 0;
        int n0 = 0 ;
        for (int i = 0; i < strs.length; i++) {
            String now = strs[i];
            n1 = 0;
            n0 = 0;
            for (int j = 0; j < now.length(); j++) {
                if(now.charAt(j)=='0')n0++;
                else n1++;
            }
            for (int m1 = m; m1 >=n0; m1--) {
                for (int n2 = n; n2 >=n1; n2--) {
                    dp[m1][n2] = Math.max(dp[m1][n2],dp[m1-n0][n2-n1]+1);
                }
            }
        }
        return dp[m][n];
    }
}