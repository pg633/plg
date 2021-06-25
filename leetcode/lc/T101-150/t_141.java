package leetcoder;


import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null||head.next ==null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow){
            if(fast.next!=null && fast.next.next!=null){
                fast =fast.next.next;
            }
            else return false;
            slow = slow.next;
        }
        return true;
    }
}

public class Main {

    public static void main(String[] arg) {



    }

}