package leetcoder;


import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String  s:tokens)
            switch (s) {
                case "+": {
                    Integer n1 = st.pop();
                    Integer n2 = st.pop();
                    st.push(n1+n2);
                }
                break;
                case "-":{
                    Integer n1 = st.pop();
                    Integer n2 = st.pop();
                    st.push(n2-n1);
                }
                break;
                case "*":{
                    Integer n1 = st.pop();
                    Integer n2 = st.pop();
                    st.push(n1*n2);
                }
                break;
                case "/":{
                    Integer n1 = st.pop();
                    Integer n2 = st.pop();
                    if(n1 != 0)
                        st.push(n2/n1);
                    else st.push(0);
                }
                break;
                default:
                    st.push(new Integer(s));
                    break;
            }
        return st.pop();
    }
}
public class Main {

    public static void main(String[] arg) {


    }

}