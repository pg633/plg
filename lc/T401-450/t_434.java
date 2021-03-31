package leetcoder;


import java.util.*;

class Solution {
    public int countSegments(String s) {
        String trim = s.trim();
        if("".equals(trim)) return 0;
        return trim.split("\\s+").length;
    }
}

public class AAA{
    public static void main(String[] args) {

        System.out.println(new Solution().countSegments("    foo    bar"));
    }
}