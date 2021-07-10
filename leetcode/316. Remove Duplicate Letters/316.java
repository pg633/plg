package leecoder;

import leetcoder.ListNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String removeDuplicateLetters(String s) {
        int []count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c-'a'] ++;
        }
        // 多少个
        int index = 0;
        for (int i : count) {
            if(i>0) index ++ ;
        }
        //
        Stack<Character> st = new Stack<>();
        boolean []vis = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 栈顶 元素 比 当前小 顶之后 仍会 出 先
            while(!st.isEmpty() && st.peek() > c && count[st.peek() - 'a'] > 1  && !vis[c-'a']){
                vis[st.peek()-'a'] =false;
                count[st.peek() - 'a'] --;
                st.pop();
            }
            if(vis[c-'a']){
                count[c-'a']--;
                continue;
            }
            st.push(c);
            vis[c-'a'] = true;
//             count[c-'a']--;







        }
        char []res = new char[index];

//         while(!st.isEmpty()) System.out.print(st.pop());

        while (!st.isEmpty())
            res[--index] = st.pop();
        return String.valueOf(res);

    }

}




public class Main {
    public static void main(String[] args) {
        String bcabc = new leecoder.Solution().removeDuplicateLetters("bcabc");
        System.out.println(bcabc);

    }
}