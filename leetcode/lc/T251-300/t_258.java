package leetcoder;

import java.util.*;

class Solution {
    public int addDigits(int num) {
        if(num <10) return num;
        int n = 0;
        while(num!=0){
            n += num%10;
            num/=10;
        }
        return addDigits(n);
    }
}
public class Main {

    public static void main(String[] arg) {



    }

}

