package leetcoder;


import java.util.*;


class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer,Integer> m = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            m.put(intervals[i].start,i);
        }
        int []res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if(m.containsKey(intervals[i].end)){
                res[i] = m.get(intervals[i].end);
                continue;
            }else{
                Map.Entry<Integer, Integer> integerIntegerEntry = m.higherEntry(intervals[i].end);
                if(integerIntegerEntry == null) res[i] = -1;
                else res[i] = integerIntegerEntry.getValue();
            }
        }
        return res;
    }
}
