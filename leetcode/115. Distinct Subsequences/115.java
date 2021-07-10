package leetcoder;

class Solution {

    public int numDistinct(String s, String t) {
        char [] des = s.toCharArray();
        char [] src = t.toCharArray();
        int dp [][] = new int[des.length+1][src.length+1];

        for(int i=0;i<des.length;i++)
            dp[i][0] =1;

        for(int i=1;i<=des.length;i++)
            for(int j=1;j<=src.length;j++){
                dp[i][j] = dp[i-1][j];
                if(des[i-1] == src[j-1])
                    dp[i][j] += dp[i-1][j-1];
            }
        return dp[des.length][src.length];
    }
}

//
//class Solution {
//    public int numDistinct(String s, String t) {
//        char [] des = s.toCharArray();
//        char [] src = t.toCharArray();
//        if(des.length < src.length) return 0;
//
//        int [] dp = new int [des.length+1];
//        dp[0] =1;
//
//
//        for(int i=0;i<des.length;i++)
//            for(int j=src.length-1;j>=0;j--){
//                if(des[i]==src[j])dp[j+1] +=dp[j];
//            }
//        return dp[src.length];
//    }
//}






class Main {
    public static void main(String[] arg) {
        System.out.println( new leetcoder.Solution().numDistinct("rabbbit","rabbit"));
    }

}