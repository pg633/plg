package leetcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Solution {
    public boolean isPowerOfFour(int num) {
        if(num ==0) return false;
        if(num==1) return true;
        if(num%4!=0)return false;
        return isPowerOfFour(num/4);
    }
}










public class AAA {
    public static void main(String[] args) {

        System.out.println(new Solution().isPowerOfFour(5));

    }
}
