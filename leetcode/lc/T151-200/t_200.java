package leetcoder;

import javax.xml.transform.SourceLocator;
import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        boolean vis[][] = new boolean[row][col];
        int ans =0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!vis[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        if(i<grid.length && i >=0 && j<grid[0].length && j>=0) {
            if(vis[i][j])return;
            vis[i][j] = true;
            ;if(grid[i][j]=='1'){
                dfs(i+1,j,grid,vis);
                dfs(i,j+1,grid,vis);
                dfs(i-1,j,grid,vis);
                dfs(i,j-1,grid,vis);
            }else {
                return;
            }
        }
    }
}





public class Main {

    public static void main(String[] arg) {
        System.out.println("aaaaaaaaaaaaa");
    }

}