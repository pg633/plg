package leetcoder;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        List<String> words = new ArrayList<>();
        int begin = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(m.get(c) < k){
                words.add(s.substring(begin,i));
                begin = i+1;
            }
        }
        if(begin!=s.length()) words.add(s.substring(begin));


        int max = 0;
        for (String word : words) {
            if(ok(word,k)){
                max = Math.max(max,word.length());
            }else {
                max = Math.max(max, longestSubstring(word,k));
            }
        }
        return max;
    }

    private boolean ok(String s,int k) {
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(m.get(s.charAt(i)) < k) return false;
        }
        return true;
    }
}


public class AAA {
    public static void main(String[] args) {

        int aaabb = new Solution().longestSubstring("bbaaacbb", 3);
        System.out.println(aaabb);


    }
}
