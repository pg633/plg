package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s1.size()==0)return s2.pop();
        else{
            while(s1.size() !=1){
                s2.push(s1.pop());
            }
            return s1.pop();
        }
    }

    /** Get the front element. */
    public int peek() {

        if(s1.size()==0)return s2.peek();
        else {
            while(s1.size() !=1){
                s2.push(s1.pop());
            }
            return s1.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return  s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class Main {

    public static void main(String[] arg) {
    }

}