package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0){
            return 0;
        }
        int []dp = new int[ratings.length];
        for (int i = 0; i < dp.length; i++){
            dp[i]=1;
        }

        for (int i = 0; i < dp.length-1; i++) {
            if(ratings[i+1]>ratings[i]){
                dp[i+1] = dp[i]+1;
            }
        }

        for (int i = dp.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1] && dp[i] <= dp[i+1]){
                dp[i] = dp[i+1]+1;
            }
        }
        int sum = 0;
        for(int i:dp){
            sum+=i;
//            System.out.print(i+"  ");
        }
        return sum;
    }

}
public class Main {

    public static void main(String[] arg) {
        new leetcoder.Solution().candy(new int[]{1,0,2});

    }

}