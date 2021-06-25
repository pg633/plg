package leetcoder;


import javax.print.DocFlavor;
import java.util.Stack;

import static java.lang.Math.max;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int len = matrix.length;
        int len2 = matrix[0].length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                if (i != 0 && matrix[i][j] == '1') {
                    matrix[i][j] = (char) (matrix[i-1][j] + 1);
                }
            }
            max = Math.max(max, maxArea(matrix[i]));
            System.out.println(max);
        }



        return max;
    }
    public  int maxArea(char[] d){
        int len = d.length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int  i=0;
        for(;i<len ;i++){
            if(s.empty() || d[s.peek()] <= d[i]){
                s.push(i);
            }else{
                int now = s.pop();
                max = Math.max(max,(s.empty()? i: i-s.peek()-1 )*(d[now]-'0'));
                i--;
            }
        }
        while(!s.empty()){
            int now = s.pop();
            max = Math.max(max,(s.empty()?i:i-s.peek()-1 )*(d[now]-'0'));
        }
        return max;
    }




}



public class Main {
    public static void main(String[] arg) {
        String  [] [] a =   {
                {"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}};

        char [][] d =  new char[a.length][a[0].length];

        for (int i =0 ;i< a.length;i++)
            for (int j =0;j<a[0].length;j++){
                d[i][j] =  a[i][j].charAt(0);
            }

        for(char[] dd :d ){
            System.out.println(dd);
        }

        char [][] as ={{'1','0'}};

        System.out.println( new leetcoder.Solution().maximalRectangle(as)    );



    }


}

