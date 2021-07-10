package  leetcoder;

import java.util.Stack;


class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            switch (s.charAt(i))
            {
                case '(':
                {
                    st.push(1);
                }break;
                case '{':
                {
                    st.push(2);
                }break;
                case '[':
                {
                    st.push(3);
                }break;
                case ')':
                {
                    if(st.isEmpty() || st.pop()!=1) return false;
                }break;
                case '}':
                {
                    if(st.isEmpty() || st.pop()!=2) return false;

                }break;
                case ']':
                {
                    if(st.isEmpty() || st.pop()!=3) return false;

                }break;
            }
        }
        return st.isEmpty();
    }
}