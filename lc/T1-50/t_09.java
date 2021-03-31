package leetcoder;

import java.io.IOException;


class Solution {
    public boolean isPalindrome(int x) {
        if(x<0||x!=0&&x%10==0)
            return false;
        int s =0;
        while(s<x){
            s=s*10+x%10;
            x/=10;
        }
        return s==x||s/10==x;
    }
}
