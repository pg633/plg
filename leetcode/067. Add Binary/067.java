package leetcoder;

import java.lang.reflect.Array;
import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0) return b;
        if(b==null||b.length()==0) return a;
        int up =0;
        int i=0;
        String res ="";
        while(i<a.length() &&i<b.length()){
            up = up + a.charAt(a.length()-1-i) + b.charAt(b.length()-i-1) -'0'-'0';
            res=res+up%2;
            up/=2;
            i++;
        } while(i<a.length() ){
            up = up + a.charAt(a.length()-1-i)  -'0';
            res=res+up%2;
            up/=2;
            i++;
        } while( i<b.length()){
            up = up +   b.charAt(b.length()-i-1) -'0' ;
            res=res+up%2;
            up/=2;
            i++;
        }
        while(up!=0){
            res = res+up%2;
            up/=2;
            i++;
        }
        return new StringBuilder(res).reverse().toString() ;

    }
}



