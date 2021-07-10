package leetcoder;


import java.util.List;


class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt((long )2*n+0.25)-0.5);
    }
}