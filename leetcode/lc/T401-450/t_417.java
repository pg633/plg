package leetcoder;


import java.util.*;
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix.length == 0|| matrix[0].length ==0) return new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean [][]vis1 = new boolean[n][m];
        boolean [][]vis2 = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            dfs(matrix,vis1,i,0);
            dfs(matrix,vis2,i,m-1);
        }
        for (int j = 0; j < m; j++) {
            dfs(matrix,vis1,0,j);
            dfs(matrix,vis2,n-1,j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis1[i][j] && vis2[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] vis, int i, int j) {

        vis[i][j] = true;
        final int[][]dir ={{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        for (int[] ints : dir) {
            int x = i+ints[0];
            int y = j+ints[1];
            if(x< 0 || x>=matrix.length || y<0 ||y>=matrix[0].length
                    ||vis [x][y]==true|| matrix[x][y] < matrix[i][j]) continue;
            dfs(matrix,vis,x,y);
        }

    }
}


public class AAA {
    public static void main(String[] args) {
        List<int[]> ints = new Solution().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        for (int[] anInt : ints) {
            System.out.println(anInt[0]+"  "+ anInt[1]);
        }
    }
}
