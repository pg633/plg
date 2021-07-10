package leetcoder;

import java.util.*;


class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int [][]dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length-1 ; i >=0; i--) {
            for (int j = dungeon[0].length-1; j >=0 ; j--) {
                if(i == dungeon.length-1  && j==dungeon[0].length-1){
                    dp[i][j] = Math.max(1,1-dungeon[i][j]);
                }else if(i == dungeon.length-1){
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                }else if( j==dungeon[0].length-1){
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                }else{
                    dp[i][j] = Math.max(1, Math.min( dp[i+1][j] ,dp[i][j+1]) - dungeon[i][j] );
                }
            }
        }
        return dp[0][0];
    }
}




public class Main {

    public static void main(String[] arg){
        int [][] a = new int[][]{
                {-2,-3,3},{-5,-10,1},{10,30,-5}
        };
        int i = new Solution().calculateMinimumHP(a);
        System.out.println(i);;

    }

}