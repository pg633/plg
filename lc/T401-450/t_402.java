package leetcoder;


import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == num.length()) return "0";
        Deque<Character> q = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(!q.isEmpty() && q.peek() > c && k>0) {
                q.pop();
                k--;
            }
            if(q.isEmpty() && c =='0') continue;;
            q.push(c);
        }
        while(k-- != 0)
            q.pop();
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())sb.append(q.pop());
        sb.reverse();
        return sb.length()==0 ? "0":sb.toString();
    }
}

public class AAA {
    public static void main(String[] args) {
        String s = new Solution().removeKdigits("102000", 1);
        System.out.println(s);
    }
}
