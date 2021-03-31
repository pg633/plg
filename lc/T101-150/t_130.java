package leetcoder;


import java.io.FileInputStream;
import java.util.*;


class Solution {
    int row,col;
    public void solve(char[][] board) {
        if(board==null||board.length==0)
            return ;
        row=board.length;
        col=board[0].length;
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }
        return ;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')
            return;
        board[i][j]='-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return ;
    }
}


public class Main {

    public static void main(String[] arg) {
//        char[][]dp ={{'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//        };
        char [][]dp ={{'O'}};
        new leetcoder.Solution().solve(dp);
        for (int i = 0; i < dp.length; i++) {

            System.out.println(Arrays.toString(dp[i]));
        }


    }

}