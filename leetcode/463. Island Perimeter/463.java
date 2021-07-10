package leetcoder;


import org.w3c.dom.Node;

import java.util.*;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    res+=4;
                    if( i+1<grid.length && grid[i+1][j] ==1) res-=2;
                    if(j+1<grid[i].length && grid[i][j+1]==1) res-=2;
                }
            }
        }
        return res;
    }
}


public class AAA {
    public static void main(String[] args) {

    }
}