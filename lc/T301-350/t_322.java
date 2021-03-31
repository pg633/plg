package leecoder;

import leetcoder.ListNode;
import org.graalvm.compiler.nodes.calc.IntegerConvertNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i-coin >=0 ){
                    dp[i] = Math.min(dp[i] , dp[i - coin] +1);
                }
            }
        }
//         System.out.println(Arrays.toString(dp));
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}

public class Main {
    public static void main(String[] args) {

        int i = new leecoder.Solution().coinChange(new int[]{1, 2147483647}, 2);
        System.out.println(i);
    }
}