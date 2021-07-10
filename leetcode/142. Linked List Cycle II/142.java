package leetcoder;


import java.util.*;

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode fast = head;
        ListNode slow = head;
        if(fast.next!=null &&fast.next.next!=null)
            fast = fast.next.next;
        else return null;
        slow = slow.next;
        while(fast != slow){
            if(fast.next!=null &&fast.next.next!=null)
                fast = fast.next.next;
            else return null;
            slow = slow.next;
        }
        while(p!=slow){
            p=p.next;
            slow = slow.next;
        }
        return p;
    }
}

public class Main {

    public static void main(String[] arg) {



    }

}