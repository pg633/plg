package leetcoder;


import org.w3c.dom.Node;

import java.util.*;


class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        boolean flag1 = false;
        boolean flag2 = false;
        int j=0;
        int num = 0;
        double time = 0;

        do{
            for (int i = 0; i < cs1.length; i++) {
                if(cs1[i] == cs2[j]){
                    j++;
                    time++;
                    if (j >= cs2.length){
                        j=0;
                        flag2 = true;
                    }
                }
            }
            num++;
            if(num == n1){
                flag1 = true;
            }
        }while(!(time %cs2.length==0) && !flag1);
        double a = time / cs2.length;
        return (int)(a*n1/(num*n2));
    }
}


public class AAA {
    public static void main(String[] args) {

    }
}