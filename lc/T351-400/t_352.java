/**
 *   我不知道 错在 什么地方了 ，难受
 */

class SummaryRanges {

    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        Interval cur = new Interval(val,val);
        List<Interval> res = new ArrayList<>();
        int pos = 0;

        for (Interval interval : v) {
            if(cur.end + 1 < interval.start){
                res.add(interval);
            }else if(cur.start > interval.end) {
                res.add(interval);
                ++pos;
            }else {
                cur.start = Math.min(cur.start,interval.start);
                cur.end = Math.max(cur.end ,interval.end);
            }
        }
        res.add(pos,cur);
        v = res;
    }

    public List<Interval> getIntervals() {
        return v;
    }
    private List<Interval>  v =  new ArrayList<>();

}