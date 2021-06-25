package leetcoder;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Spliterator;



class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int []dp = new int[60];
        for (int i = 0; i < 60; i++) dp[i] = calc(i);
        for (int i = 0; i <12 ; i++) {
            for (int j = 0; j < 60; j++) {
                if(dp[i] +dp[j] == num){
                    res.add(new String(i+":"+(j>=10?j:"0"+j)));
                }
            }
        }
        return res;
    }

    private int calc(int i) {
        String s = Integer.toBinaryString(i);
        int res= 0;
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j)=='1') res++;
        }
        return res;
    }
}


public class AAA {
    public static void main(String[] args) {
        List<String> strings = new Solution().readBinaryWatch(1);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
