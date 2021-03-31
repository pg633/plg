package leetcoder;

import java.util.*;

/**
 * 亦或 取出其中不同的位 ，分流处理
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a^= nums[i];
        }
        int xor = 1;
        while((a&1) ==0){
            a>>=1;
            xor<<=1;
        }

        for (int i: nums) {
            if((i&xor)>0)
                res[0]^=i;
            else
                res[1]^=i;
        }

        return res;
    }
}



public class Main {

    public static void main(String[] arg) {
        int[] ints = new leetcoder.Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

}

