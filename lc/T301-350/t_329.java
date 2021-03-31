package leecoder;


import leetcoder.Interval;
import leetcoder.ListNode;

import java.util.List;
import java.util.TreeMap;

class Solution {


    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        boolean [][] vis = new boolean[n][m];
        int [][] path = new int[n][m];
        int max = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max,find(matrix,vis,path,i,j));
            }
        }
        return max;
    }

    private int find(int[][] matrix, boolean[][] vis, int[][] path, int i, int j) {
        if(vis[i][j]) return path[i][j];
        path[i][j] =1 ;
        int [][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int n = matrix.length;
        int m = matrix[0].length;

        for (int[] ints : dir) {
            int x = i + ints[0];
            int y = j + ints[1];
            if(isVaild(x,y,n,m) && matrix[x][y] > matrix[i][j]) {
                path[i][j] = Math.max(path[i][j], find(matrix, vis, path, x, y) + 1);
            }
        }
        vis[i][j] = true;
        return path[i][j];
    }
    private boolean isVaild(int x, int y, int n, int m) {
        return x>=0 && x<n &&y>=0&&y<m;
    }
}


public class Main {
    public static void main(String[] args) {

        int i = new leecoder.Solution().longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        });
        System.out.println(i);


    }
}