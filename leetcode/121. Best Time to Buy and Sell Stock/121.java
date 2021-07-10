package leetcoder;

import java.awt.event.MouseAdapter;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max =  0;
        for (int i=0;i<prices.length;i++){
            min  = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}



public class Main {

    public static void main(String[] arg) {
        int k = new leetcoder.Solution().maxProfit( new int[] {7,1,5,3,6,4});
        System.out.println(k);

    }

}