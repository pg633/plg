package leetcoder;

import java.util.*;


class Solution {
    public boolean isUgly(int num) {
        if(num ==0  ) return false;
        while(true){
            if(num==1) return true;
            if(num%2==0) num/=2;
            else if(num%3==0) num/=3;
            else if(num%5==0) num/=5;
            else return false;
        }
    }
}



public class Main {

    public static void main(String[] arg) {


    }

}

