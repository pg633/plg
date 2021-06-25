package leetcoder;


import java.util.*;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length ==0) return 0;
        int res = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] - timeSeries[i-1] >= duration){
                res += duration;
            }else {
                res+= timeSeries[i] - timeSeries[i-1];
            }
        }
        return res;
    }
}





public class AAA {
    public static void main(String[] args) {

        int[] ints = new Solution().nextGreaterElement(new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}