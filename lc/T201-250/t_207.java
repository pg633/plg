package leetcoder;


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        Map<Integer,List<Integer> > m  = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            m.put(i,new ArrayList<>());
        }


        int [] degree = new int [numCourses];

        for (int[]p: prerequisites){
            m.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(degree[i]==0)((LinkedList<Integer>) q).add(i);
        }
        if(q.size()==0){
            return false;
        }
        while (!q.isEmpty()){
            int id = ((LinkedList<Integer>) q).pollFirst();
            List<Integer> list = m.get(id);
            for(Integer it : list){
                degree[it]--;
                if(degree[it]==0){
                    ((LinkedList<Integer>) q).add(it);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if(degree[i]!=0)
                return false;
        }

        return true;

    }
}








public class Main {

    public static void main(String[] arg) {


    }

}