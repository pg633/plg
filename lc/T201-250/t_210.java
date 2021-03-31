package leetcoder;


import Concurrency.mid.Collections2;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> m = new HashMap();
        for (int i = 0; i < numCourses; i++)  m.put(i,new ArrayList<>());
        int[] degre = new int[numCourses];
        // 0 ==> 1
        for(int []p:prerequisites) {
            m.get(p[1]).add(p[0]);
            degre[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res =  new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if(degre[i] == 0 && !res.contains(i)) {
                ((LinkedList<Integer>) q).add(i);

            }
            while(!q.isEmpty() && res.size() < numCourses){
                int id = ((LinkedList<Integer>) q).pollFirst();
                res.add(id);
                List<Integer> list = m.get(id);
                for(int it: list){
                    degre[it]--;
                    if(degre[it] ==0 && !res.contains(it)) {
                        ((LinkedList<Integer>) q).add(it);
                    }

                }
            }
        }
//        System.out.println(res);
        if(res.size()!=numCourses) return new int[]{};
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}


public class Main {

    public static void main(String[] arg) {

        int n  =4 ;
        int [][]a = new int[][]{{1,0},{2,0},{3,1},{3,2},{1,3}};
        int[] order = new leetcoder.Solution().findOrder(n, a);
//        System.out.println(order);;
    }

}