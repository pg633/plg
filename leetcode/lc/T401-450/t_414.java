package leetcoder;

import java.lang.reflect.Array;
import java.util.*;




class Solution {
    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        boolean flag= true;
        for (int i : nums) {
            if(i==Integer.MIN_VALUE) flag = false;
            if(a==i||b==i||c==i) continue;
            if(a == Integer.MIN_VALUE || i>a){
                c =b;
                b = a;
                a = i;
            }else if (b == Integer.MIN_VALUE || i>b){
                c = b;
                b = i;
            }else if(c==Integer.MIN_VALUE||i>c){
                c = i;
            }
        }
        if(flag) return (c==Integer.MIN_VALUE)?a:c;
        else if(b ==Integer.MIN_VALUE ||a == Integer.MIN_VALUE) return a;
        else return Integer.MIN_VALUE;
    }
}

public class AAA {
    public static void main(String[] args) {

        int i = new Solution().thirdMax(new int[]{1,2,2,5,3,5});
        System.out.println(i);

    }
}
