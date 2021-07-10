package leetcoder;


import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length ==0 )return;
        int[][]dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dp[i][j] = board[i][j];
            }
        }
        for (int[] ints : board) {
            Arrays.fill(ints,0);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                if (alive(dp, i, j)) {
                    board[i][j] = 1;
                }
        }
        return;


    }

    private boolean alive(int[][] dp, int i, int j) {
        int res = 0;
        for (int k = -1; k <=1 ; k++) {
            for (int l = -1; l <= 1; l++) {
                int x = i+k;
                int y = j+l;
                if(x ==i && j==y) continue;
                if(x<0 || x>=dp.length || y<0||y>= dp[0].length){
                    continue;
                }else {
                    if(dp[x][y] == 1) res ++;
                }
            }
        }
        if(dp[i][j] ==1){
            if(res<2) return false;
            else if(res == 2 || res ==3) return true;
            else return false;
        }else{
            if(res == 3) return true;
            else return false;
        }

    }
}




public class Main {

    public static void main(String[] arg) {
        int [][] arr = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        new leetcoder.Solution().gameOfLife(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }



    }

}

