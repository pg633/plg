package leetcoder;

import java.awt.event.MouseAdapter;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        for (int i=1;i<prices.length;i++){
            if(prices[i] >prices[i-1]){
                max+= prices[i]- prices[i-1];
            }
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