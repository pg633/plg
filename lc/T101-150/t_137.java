package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;


class Solution {
    public int singleNumber(int[] nums) {
        int a=0;
        int b=0;
        for(int i:nums){
            b=~a & (b^i);
            a=~b&(a^i);
        }
        return b;
    }
}

public class Main {

    public static void main(String[] arg) {


    }

}