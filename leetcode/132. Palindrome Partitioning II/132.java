package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;


class Solution {
    public int minCut(String s) {
        int[][]dp = new int[s.length()][s.length()];
        int [] w = new int[s.length()+1];

        for (int i = s.length()-1; i >=0; i--) {
            w[i] = s.length()-i;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j) &&( j-i<=1 || dp[i+1][j-1]==1 ) ){
                    dp[i][j] =1;
                    w[i] = Math.min(w[i],1+w[j+1]);
                }
            }
        }
        return w[0]-1;
    }

}



public class Main {

    public static void main(String[] arg) {
        int aab = new leetcoder.Solution().minCut("aab");
        System.out.println(aab);

    }

}