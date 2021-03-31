package leetcoder;


import java.util.*;
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return ;
        ListNode tmp = head;
        Deque<ListNode> deque = new LinkedList<>();
        while(tmp!=null){
            ((LinkedList<ListNode>) deque).add(tmp);
            tmp = tmp.next;
        }

        while(!deque.isEmpty()){
            if(deque.size()>=2){
                ListNode first = deque.pollFirst();
                ListNode second = deque.pollLast();
                if(tmp != null){
                    tmp.next = first;
                }
                first.next = second;
                second.next = null;
                tmp = second;
            }else{
                ListNode first = deque.pollFirst();
                if(tmp != null){
                    tmp.next = first;
                }
                tmp = first;
                tmp.next = null;

            }
        }
        return;

    }
}

public class Main {

    public static void main(String[] arg) {



    }

}