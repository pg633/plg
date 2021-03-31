package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;


class Solution {
    public int singleNumber(int[] nums) {
        int id =0;
        for (int i:nums) {
            id^=i;
        }
        return id;
    }
}

public class Main {

    public static void main(String[] arg) {


    }

}