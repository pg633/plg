package leetcoder;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
class MinStack {

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(min.isEmpty()){
            min.push(x);
        }else{
            Integer minTop = min.peek();
            if(minTop >= x){
                min.push(x);
            }
        }
        real.push(x);
    }

    public void pop() {
        int x = real.pop();
        if(min.peek() == x){
            min.pop();
        }
    }

    public int top() {
        return real.peek();
    }

    public int getMin() {
        return min.peek();
    }
    Stack<Integer> real = new Stack<>();
    Stack<Integer> min = new Stack<>();
}

public class Main {

    public static void main(String[] arg) {


    }

}