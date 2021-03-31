package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int trailingZeroes(int n) {
        int res =0;
        while(n!=0){
            n/=5;
            res +=n;
        }
        return res;
    }
}

public class Main {

    public static void main(String[] arg){

        int a = new Solution().trailingZeroes(10);
        System.out.println(a);


    }

}