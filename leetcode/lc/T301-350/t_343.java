package leetcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Solution {
    public int integerBreak(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        if(n==3) return 2;
        int n1 = n/3;
        int n2 = n%3;
        if(n2 == 1 ){
            n1 --;
            n2+=3;
        }
        if(n1<0 ) return n2;
        return (int)Math.pow(3,n1)*(n2==0?1:n2);
    }
}









public class AAA {
    public static void main(String[] args) {

        System.out.println(new Solution().integerBreak(10));

    }
}
