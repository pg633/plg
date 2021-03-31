package leetcoder;


import org.w3c.dom.ls.LSInput;

import java.io.FileInputStream;
import java.util.*;

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return head;
        HashMap<Integer, RandomListNode> m = new HashMap<>();
        RandomListNode node = new RandomListNode(head.label);

        m.put(head.label,node);
        return copy(m,head,node);

    }

    private RandomListNode copy(HashMap<Integer, RandomListNode> m, RandomListNode head, RandomListNode node) {
        m.put(head.label,node);
        if (head.next != null) {
            if(m.containsKey(head.next.label)){
                node.next = m.get(head.next.label);
            }else{
                RandomListNode n = new RandomListNode(head.next.label);
                node.next = copy(m,head.next,n);
            }
        }
        if(head.random!=null){
            if(m.containsKey(head.random.label)){
                node.random = m.get(head.random.label);
            }else{
                RandomListNode n = new RandomListNode(head.random.label);
                node.random = copy(m,head.random,n);
            }
        }
        return node;
    }

}
public class Main {

    public static void main(String[] arg) {


    }

}