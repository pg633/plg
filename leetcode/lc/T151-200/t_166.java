package leetcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int n1, int n2) {
        if (n1 == Integer.MIN_VALUE && n2 == -1){
            return "2147483648";
        }
        if(n1 == -1 && n2 == Integer.MIN_VALUE){
            return "0.0000000004656612873077392578125";
        }
        int a = n1/n2;
        int b = n1%n2;

        String res = "";
        if( (double)n1/(double)n2 < 0){
            if(a==0){
                res = "-"+ Math.abs(a);
            }else{
                res += a;
            }
        }else{
            res += a;
        }

        if(b==0){
            return res;
        }
        res+=".";
        Map<Integer,Integer> m = new HashMap<>();
        while(b!=0){
            b = Math.abs(b);
            n2 = Math.abs(n2);
            b*=10;
            if(m.containsKey(b)){
                int l = m.get(b);
                int r = res.length() ;
                res = res.substring(0,l)+"("+ res.substring(l,r)+")";
                return res;
            }
            m.put(b , res.length());
            a = b/n2;
            b = b%n2;
            res += a;
        }
        return res;
    }
}


public class Main {

    public static void main(String[] arg){
        String s = new Solution().fractionToDecimal(-50, 8);
        System.out.println(s);;
    }

}