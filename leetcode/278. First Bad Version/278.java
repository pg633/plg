package leetcoder;

import java.util.*;


class Solution   {
    public int firstBadVersion(int n) {
        int l= 1;
        int r = n;
        while(l<r){
            int m = l + (r - l) / 2;
            if(isBadVersion(m)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return r;
    }
    boolean isBadVersion(int version){
        if(version>=2) return true;
        else return false;
    }

}

public class Main {

    public static void main(String[] arg) {
        int i = new leetcoder.Solution().firstBadVersion(3);
        System.out.println(i);


    }

}

