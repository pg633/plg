package leetcoder;

import java.util.*;


class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res =0;
        for (int i = citations.length-1; i >=0; i--) {
            int  k = citations.length - i ;
            if(citations[i] >= k){
                res = k;
            }else {
                break;
            }
        }
        return res;
    }
}

public class Main {

    public static void main(String[] arg) {
        int i = new leetcoder.Solution().hIndex(new int[]{3,0,6,1,5});
        System.out.println(i);

    }

}

