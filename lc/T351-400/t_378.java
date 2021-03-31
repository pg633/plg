package leetcoder;


import java.util.*;


class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(q.size() < k){
                    q.offer(matrix[i][j]);
                }else  if(q.peek() > matrix[i][j]){
                    q.poll();
                    q.offer(matrix[i][j]);
                }
            }
        }
        return q.peek();
    }
}


public class AAA {
    public static void main(String[] args) {



    }
}
