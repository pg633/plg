package leetcoder;

import DateStruct.Alg.max;
import sun.jvm.hotspot.tools.soql.SOQL;

import javax.print.attribute.standard.PrinterResolution;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class MedianFinder {
    private PriorityQueue<Integer> minQ  = new PriorityQueue();
    private PriorityQueue<Integer> maxQ = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(num<findMedian()) maxQ.add(num);
        else minQ.add(num);
        if(maxQ.size() > minQ.size()) minQ.add(maxQ.poll());
        else if( minQ.size() - maxQ.size()  > 1) maxQ.add(minQ.poll());

    }

    public double findMedian() {
        if(minQ.isEmpty() &&maxQ.isEmpty()) return 0;
        if(maxQ.size()== minQ.size()) return (minQ.peek() + maxQ.peek())/2.0;
        return minQ.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class Main {

    public static void main(String[] arg) {
        leetcoder.MedianFinder medianFinder = new leetcoder.MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());


    }

}

