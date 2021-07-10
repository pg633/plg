package leetcoder;


import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 收益 p 需要 C
        // pq 能启动  pc 不能启动
        PriorityQueue<node> pq = new PriorityQueue<node>( (o1,o2) ->  o2.w - o1.w);
        PriorityQueue<node> pc = new PriorityQueue<node>( (o1,o2) ->  o1.c - o2.c);
        for (int i = 0; i < Profits.length; i++) {
            if(Capital[i] <= W) pq.add(new node(Profits[i],Capital[i]));
            else pc.add(new node(Profits[i],Capital[i]));
        }
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            W +=pq.poll().w;
            while(!pc.isEmpty() && W >= pc.peek().c){
                pq.add(pc.poll());
            }

        }
        return W;
    }
    class node {
        int w,c;
        node(int w,int c){
            this.w = w;
            this.c = c;
        }
    }
}





public class AAA {
    public static void main(String[] args) {



    }
}