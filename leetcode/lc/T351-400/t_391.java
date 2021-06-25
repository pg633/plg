package leetcoder;


import java.util.*;

class Solution {
    class node {
        int x;
        int y;
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            node node = (node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        if(n==0) return false;
        int dx1 = Integer.MAX_VALUE;
        int dx2 = Integer.MIN_VALUE;
        int dy1= Integer.MAX_VALUE;
        int dy2 = Integer.MIN_VALUE;


        Set<String> s = new HashSet<>();
        int sumArea = 0;
        for (int[] re : rectangles) {
            int x1 = re[0];
            int y1 = re[1];
            int x2 = re[2];
            int y2 = re[3];
            sumArea+= (x2-x1) * (y2-y1);
            dx1 = Math.min(dx1,x1);
            dx2 = Math.max(dx2,x2);
            dy1 = Math.min(dy1,y1);
            dy2 = Math.max(dy2,y2);
            String s1 = x1+" " +y1;
            String s2 = x1+" " +y2;
            String s3 = x2+" " +y1;
            String s4 = x2+" " +y2;
            con(s,s1);
            con(s,s2);
            con(s,s3);
            con(s,s4);
        }





        if(s.size() ==4 && s.contains(dx1+" " +dy1)
                &&s.contains(dx1+" " +dy2)  &&s.contains(dx2+" " +dy1)  &&s.contains(dx2+" " +dy2) )
            return sumArea - (dx2-dx1) * (dy2-dy1) ==0 ;
        return false;

    }

    private void con(Set<String> s, String s1) {
        if(s.contains(s1)) s.remove(s1);
        else s.add(s1);
    }
}

public class AAA {
    public static void main(String[] args) {
        int [][] dp  = new int[][]{
                {1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}
        };


        boolean rectangleCover = new Solution().isRectangleCover(dp);
        System.out.println(rectangleCover);


    }
}
