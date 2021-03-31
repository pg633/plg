import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if(s== null ||s.length()==0) return 0;
         int res = 0;
         int start =0;
        Stack<Integer> st = new Stack<>();
         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i)=='(')st.push(i);
             else {
                 if(st.empty()) start = i;
                 else {
                     st.pop();
                     res = st.empty()? Math.max(res,i-start+1):Math.max(res,i-m.peek());
                 }
             }
         }
         return res ;
    }
}