package leetcoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.max;


class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        for(int i =0 ;i<len;i++){
            int t = heights[i];
            max = max( max, t );
            for (int j =i+1;j<len;j++){
                t = Math.min(heights[j],t ) ;
                max = max( max, t * (j-i+1));
            }
        }
        return max;

    }
}

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer>  s = new Stack<>();
        int res = 0;
        int i =0;
        for(;i<len;i++){
            if(s.empty() || heights[s.peek()] <= heights[i] ){
                s.push(i);
            }else {
                int now = s.pop();
                int id = s.empty()?-1:s.peek();
                res = max(res,(i-1-id)*heights[now]);
                i--;
            }
        }
        while(!s.empty()){
            int now = s.pop();
            int id = s.empty()?-1:s.peek();
            res = max(res,(i-1-id)*heights[now]);
        }
        return res;
    }

    private int max(int res, int i) {
        return res > i ?res:i;
    }
}
class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length ;
        int res = 0;
        for(int i=0;i<len;i++){
            int l =i;
            int r = i;
            if(heights[l]>= heights[i] && heights[r] >=heights[i] ){
                while(l >0 && heights[l-1] >= heights[i]){
                    l--;
                }
                while(r<len && heights[r+1] >= heights[i]){
                    r++;
                }
            }
            res = max (res,(r - l +1) * heights[i]);
        }
        return res  ;
    }
}



class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int i =0 ;
        for(;i<heights.length;i++){
            if(s.empty() || heights[s.peek()] >= heights[i])
                s.push(i);
            else{
                int  now = s.pop();
                int id = s.empty()? 0:s.peek();
                res = Math.max(res,heights[now]*(i-id));
                i--;
            }
        }
        while (!s.empty()){
            int  now = s.pop();
            int id = s.empty()? 0:s.peek();
            res = Math.max(res,heights[now]*(now-id+1));
        }
        return res;

    }
}





public class Main {
    public static void main(String[] arg) {
        int []  a ={1,2,3,2};

        System.out.println( new leetcoder.Solution2().largestRectangleArea(a) );;


    }


}

覓