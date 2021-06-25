package leetcoder;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> m = new HashMap<>();
        for(int n:nums){
            if(!m.containsKey(n)) m.put(n,1);
            else m.put(n,m.get(n) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> q =new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(
        ) {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
            if(q.size() < k){
                q.offer(integerIntegerEntry);
            }else{
                if(q.peek().getValue() < integerIntegerEntry.getValue()){
                    q.poll();
                    q.offer(integerIntegerEntry);
                }
            }
        }
        List<Integer> res= new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().getKey());
        }
        return res;
    }
}



public class AAA {
    public static void main(String[] args) {


        List<Integer> list = new Solution().topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        list.forEach(System.out::println);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas");
    }
}
