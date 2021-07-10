package leetcoder;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int maxProfit(int[] prices) {
        int f1 = Integer.MIN_VALUE,f2 = 0;
        int f3 = Integer.MIN_VALUE,f4 = 0;

        for(int i=0;i<prices.length;i++){
            f1=Math.max(f1,-prices[i]);
            f2=Math.max(f2,prices[i] + f1);
            f3=Math.max(f3,-prices[i] + f2);
            f4=Math.max(f4,prices[i] + f3);
        }
        return f4;
    }
}




public class Main {

    public static void main(String[] arg) {
        int k = new leetcoder.Solution().maxProfit( new int[] {7,1,5,3,6,4});
        System.out.println(k);

    }

}