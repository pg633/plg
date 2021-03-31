package leetcoder;

import javax.sound.sampled.SourceDataLine;
import java.util.*;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int [][]dp = new int  [2][numRows];

        for(int i=0;i<numRows;i++){

            dp[i%2][0] = 1;
            dp[i%2][i] = 1;
            for(int j=1;j<i;j++){

                dp[i%2][j] = dp[(i+1)%2][j]+dp[(i+1)%2][j-1];
            }
            int[]dd=Arrays.copyOfRange(dp[i%2],0,i+1);
            ArrayList<Integer> tt = new ArrayList<>();
            for(int td : dd){
                tt.add(td);
            }
            list.add (new ArrayList<>(tt));
        }
        return  list;
    }
}

public class Main {
    public static void main(String[] arg) {
        List<List<Integer>> generate = new leetcoder.Solution().generate(3);
        for(List<Integer> list : generate){
            System.out.println(list);
        }
//        System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));



    }

}