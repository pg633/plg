package leetcoder;


import java.sql.Array;
import java.util.*;
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals == null ||intervals.size() ==0) return list;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval it  = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval t =  intervals.get(i);
            if(it.end >= t.start){
                it.end = Math.max(it.end, t.end);
            }else {
                list.add(new Interval(it.start,it.end));
                it = t;
            }
        }

        list.add(new Interval(it.start,it.end));
        return list;
    }
}