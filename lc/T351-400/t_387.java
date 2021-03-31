package leetcoder;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if(chars.length ==0) return -1;
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            m.put(chars[i],m.getOrDefault(chars[i],0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if(m.get(chars[i]) == 1) return i;
        }
        return -1;
    }
}

public class AAA {
    public static void main(String[] args) {





    }
}
