package leecoder;




class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int [] sell = new int[prices.length];
        int [] buy = new int[prices.length];
        int [] col = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i] = Math.max(buy[i-1],col[i-1] - prices[i]);
            col[i] = Math.max(col[i-1],Math.max(sell[i-1],buy[i-1]));
        }
        return sell[prices.length-1];
    }
}



public class Main {
    public static void main(String[] args) {
        System.out.println("aaaaaaaaaaaaaa");
        int i = new leecoder.Solution().maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);

    }
}