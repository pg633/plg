package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, Integer>[] diffMaps = new HashMap[A.length];
        int res = 0;
        for(int i = 0;i<A.length;i++){
            HashMap<Integer, Integer> diffMap = new HashMap();
            diffMaps[i] = diffMap;
            long num = A[i];
            for(int j=0;j<i;j++){
                if(num-A[j]>Integer.MAX_VALUE)
                    continue;
                if(num-A[j]<Integer.MIN_VALUE)
                    continue;
                int diff = (int)(num-A[j]);
                int count = diffMaps[j].getOrDefault(diff, 0);
                diffMaps[i].put(diff,diffMaps[i].getOrDefault(diff, 0)+count+1);
                res+=count;
            }
        }
        return res;
    }
}
