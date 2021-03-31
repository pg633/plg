package leetcoder;

import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<=1 || k ==0) return 0;
        if(prices.length /2 < k){
            return gc(prices);
        }
        int []buy = new int[k];
        int []sel = new int[k];
        Arrays.fill(buy,-100);
        for(int p :prices){
            for (int i = 0; i < k; i++) {
                buy[i] = Math.max(buy[i],(i==0?0:sel[i-1])-p);
                sel[i] = Math.max(sel[i],buy[i]+p);
            }
        }
        return sel[k-1];

    }

    private int gc(int[] prices) {
        int res =0 ;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                res +=prices[i] -prices[i-1];
        }
        return res;
    }
}


public class Main {

    public static void main(String[] arg) {
        int [] arr = new int[]{2,4,1};
        int k = 2;
        int i = new Solution().maxProfit(k, arr);
        System.out.println(i);
    }

}