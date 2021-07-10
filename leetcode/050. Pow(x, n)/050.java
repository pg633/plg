package leetcoder;


import java.sql.Array;
import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        int m = n<0?-n-1:n;
        double    ans -1;
        double    d= x;
        while(m>0){

            if(m%2==1){
                ans*=d;
            }
            d*=d;
            m/=2;
        }
        return n<0?1.0/ans/x:ans;
    }
}
