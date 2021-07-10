package leetcoder;


import java.util.*;

interface  GuessGame {
    int guess(int num);
}


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l<r){
            int mid = l+( r-l)/2;
            int gue = guess(mid);
            if( gue == 1) {
                l = mid + 1;
            }else if( gue == -1){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return l;
    }
}



public class AAA {
    public static void main(String[] args) {
        List<int[]> ints = new Solution().kSmallestPairs(new int[]{1, 7, 11 },new int[]{2,4,6},3);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }



    }
}
