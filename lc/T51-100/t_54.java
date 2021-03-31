package leetcoder;


import java.sql.Array;
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null||matrix.length==0) return list;
        int len = matrix.length;
        int len2 = matrix[0].length;
        int up =0;
        int down = len-1;
        int left =0;
        int right = len2-1;
        while(f(up,down,left,right)){
            p(list,matrix,up,down,left,right);
            up++;down--;left++;right--;
        }
        return list;
    }
    boolean f(int u,int d,int l,int r){
        return u<=d && l<=r;
    }
    void p(List<Integer> list , int[][] matrix,int u,int d,int l,int r){
        if(u==d){
            for(int i =l;i<=r;i++)
                list.add(matrix[u][i]);
        }else if(l==r){
            for(int i=u;i<=d;i++) {
                list.add(matrix[i][r]);
            }
        }else{
            for(int i =l;i<=r;i++)
                list.add(matrix[u][i]);
            for(int i=u+1;i<=d;i++) {
                list.add(matrix[i][r]);
            }
            for(int i=r-1;i>=l;i--) {
                list.add(matrix[d][i]);
            }
            for(int i= d-1;i>u;i--){
                list.add(matrix[i][l]);
            }
        }

    }
}
