package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int countDigitOne(int n) {
        int num = n;
        int i = 1;
        int s = 0;
        while(num!=0){
            if(num%10==0){
                s+= num/10*i;
            }else if(num%10==1){
                s+= num/10*i + n%i+1;
            }else {
                s+= Math.ceil(num/10.0)*i;
            }
            num/=10;
            i*=10;
        }
        return s;
    }
}



public class Main {

    public static void main(String[] arg) {
        System.out.println(new leetcoder.Solution().countDigitOne(13));;
    }

}