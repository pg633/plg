package leetcoder;


class Solution {
    public int reverse(int k) {
        long x = 0;
        while(k!=0){
            x= 10*x+k%10;k/=10;
        }
        return x<Integer.MIN_VALUE || x>Integer.MAX_VALUE ? 0:(int)x;
    }
}
