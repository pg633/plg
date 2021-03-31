package leetcoder;


import java.util.*;
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)return o1.end - o2.end;
                else return o1.start - o2.start;
            }
        });

        int res = 0,prev  =0, n = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[prev].end){
                res++;
                if(intervals[i].end < intervals[prev].end)
                    prev = i;
            }else{
                prev = i;
            }
        }
        return res;

    }
}

public class AAA{
    public static void main(String[] args) {

    }
}