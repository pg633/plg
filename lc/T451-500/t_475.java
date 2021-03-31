package leetcoder;


import org.w3c.dom.Node;

import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res =Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++){
            int max =Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                max = Math.min(max,Math.abs(houses[i]-heaters[j]));
            }
            res = Math.max(res,max);
        }
        return res;
    }
}

public class AAA {
    public static void main(String[] args) {

    }
}