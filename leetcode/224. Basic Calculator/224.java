package leetcoder;


import java.util.Stack;

class Solution {
    private Stack<Integer> stack = new Stack<>();
    public int calculate(String s) {
        int res = 0;
        int operator = 1;
        int num = 0;
        if(s ==null || s.length() == 0){
            return res;
        }
        for(int i=0,size=s.length(); i < size; i++){
            char singleChar = s.charAt(i);
            if(singleChar == '+'){
                res = res + num * operator;
                num = 0;
                operator = 1;
            } else if(singleChar == '-'){
                res = res + num * operator;
                num = 0;
                operator = -1;
            } else if(singleChar == '('){
                stack.push(res);
                stack.push(operator);
                res = 0;
                operator = 1;
                num = 0;
            } else if(singleChar == ')'){
                res = res + num * operator;
                num = 0;
                res = res * stack.pop();
                res = stack.pop() + res;
            } else if(singleChar != ' '){
                num = num*10 + singleChar - '0';
            }
        }
        res = res + num * operator;
        return res;
    }
}
public class Main {

    public static void main(String[] arg) {


    }

}