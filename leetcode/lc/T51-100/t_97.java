package leetcoder;


import java.util.Arrays;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;


        char [] a = s1.toCharArray();
        char [] b = s2.toCharArray();
        char [] c = s3.toCharArray();
        boolean dp [][] = new boolean[a.length+1][b.length+1];
        for(boolean []d:dp) Arrays.fill(d,true );
        for(int i=1;i<=a.length;i++){
            dp[i][0] = (a[i-1] == c[i-1]) && dp[i-1][0];
        }
        for(int i=1;i<=b.length;i++){
            dp[0][i] = (b[i-1] == c[i-1]) && dp[0][i-1];
        }
        for(int i =1;i<=a.length;i++)
            for(int j=1;j<=b.length;j++){
                dp[i][j] = ((a[i-1] == c[i+j-1])&&dp[i-1][j]   )||(  (b[j-1] == c[i+j-1]) && dp[i][j-1]);
            }
        return dp[a.length][b.length];


    }
}



class Main {

    public static void main(String[] arg) {
        String  s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//       String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" ;

        Object ob = new leetcoder.Solution().isInterleave(s1,s2,s3);
        System.out.println(ob);


    }
}