class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list =new ArrayList<>();
        if(intervals==null||intervals.size()==0){
            list.add(newInterval);
            return list;
        }

        boolean flag =true;
        for(int i=0;i<intervals.size();i++){
            Interval it = intervals.get(i);
            if(it.end < newInterval.start){
                list.add(it);
            }else if((it.end >=newInterval.start && newInterval.end >= it.start )||(it.start <=newInterval.start && newInterval.end >= it.end )){
                newInterval.start = Math.min(it.start ,newInterval.start);
                newInterval.end = Math.max(it.end ,newInterval.end);

            }else {
                if(flag) {
                    list.add(newInterval);
                    flag =false;
                }
                list.add(it);
            }
        }
        if(flag){
            list.add(newInterval);
        }
        return list;
    }
}