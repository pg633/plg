package leetcoder;


import java.util.*;




class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1,o2)->o1[1]-o2[1]);
        int tmp = 0;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            if(i==0){
                tmp = points[i][1];
                res++;
            }else{
                if(tmp >= points[i][0]) continue;
                else {
                    tmp = points[i][1];
                    res++;
                }
            }
        }
        return res;

    }
}


public class AAA {
    public static void main(String[] args) {
        int minArrowShots = new Solution().findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        System.out.println(minArrowShots);

    }
}