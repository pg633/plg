package leetcoder;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        String res = "";
        Map<Character,Integer> m = new HashMap<>();
        for(char c : t.toCharArray()){
            m.put(c, m.containsKey(c)?m.get(c)+1:1);
        }
        int min_Vlaue = s.length()+1;
        int count = t.length();
        int left  = 0;

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(m.containsKey(c))
            {
                m.put(c,m.get(c)-1);
                if(m.get(c) >=0) --count;
                while(count ==0 )
                {
                    if(i-left+1 <min_Vlaue){
                        min_Vlaue  = i - left+1;
                        res = s.substring(left,i+1);
                    }
                    if(m.containsKey(s.charAt(left))) {
                        m.put(s.charAt(left), m.get(s.charAt(left)) + 1);
                        if (m.get(s.charAt(left)) > 0) ++count;
                    }
                    ++left;
                }
            }
        }
        return res;
    }
}