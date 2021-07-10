package leetcoder;


import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> hei = new ArrayList<>();
        for (int [] p:buildings) {
            hei.add(new int[]{p[0],-p[2]});
            hei.add(new int[]{p[1],p[2]});
        }
        Collections.sort(hei, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        pq.offer(0);
        int pre = 0;
        for (int[] h:hei) {
            if(h[1]<0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(pre != cur ){
                res.add(new int[]{h[0],cur});
                pre = cur;
            }
        }
        return res;
    }
}






public class Main {

    public static void main(String[] arg) {


    }

}