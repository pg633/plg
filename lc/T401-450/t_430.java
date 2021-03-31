package leetcoder;


import java.util.*;


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};

class Solution {
    public Node flatten(Node head) {

        Stack<Node> st = new Stack<>();
        Node tHead = new Node();

        tHead.next = head;
        while(head !=null){
            if(head.child !=null){
                if(head.next!=null) st.add(head.next);
                head.next = head.child;
                head.child = null;
                head.next.prev = head;
            }else{
                if(head.next == null && !st.isEmpty()){
                    head.next = st.pop();
                    head.next.prev = head;
                }
            }
            head = head.next;
        }
        return tHead.next;

    }
}


public class AAA {
    public static void main(String[] args) {


    }
}
