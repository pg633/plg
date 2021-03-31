package leetcoder;


import java.util.*;




class Solution {
    class node{
        Character c;
        Integer id;
        public node(Character c, Integer id) {
            this.c = c;
            this.id = id;
        }
    };
    public String frequencySort(String s) {
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<node> p = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o2.id - o1.id;
            }
        });
        for (Map.Entry<Character, Integer> ci : m.entrySet()) {
            p.add(new node(ci.getKey(),ci.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!p.isEmpty()){
            node poll = p.poll();
            for (int i = 0; i < poll.id; i++) {
                sb.append(poll.c);
            }
        }
        return sb.toString();
    }
}

public class AAA {
    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Solution().findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence.toString());
        }

    }
}