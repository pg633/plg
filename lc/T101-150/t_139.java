package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}



public class Main {

    public static void main(String[] arg) {

        boolean b = new leetcoder.Solution().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        System.out.println(b);

    }

}