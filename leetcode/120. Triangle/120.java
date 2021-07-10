package leetcoder;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()==0 )return 0;
        int [][]dp = new int[triangle.size()+1][triangle.size()+1];

        for(int i=triangle.size()-1;i>=0;i--)
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) +  triangle.get(i).get(j);
            }
        return dp[0][0];

    }
}




public class Main {

    public static void main(String[] arg) {



    }

}