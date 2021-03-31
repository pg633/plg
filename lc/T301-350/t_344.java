package leetcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


class Solution {
    public void reverseString(char[] s) {
        if(s==null) return;
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            int j = len-1 - i;
            swap(s,i,j);
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;

    }
}




public class AAA {
    public static void main(String[] args) {


    }
}
