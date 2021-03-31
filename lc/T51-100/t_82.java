package leetcoder;


import java.util.Arrays;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next == null) return head;
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
        }else{
            while(head.next != null && head.next.val == head.val){
                head = head.next;
            }
            head = head.next;
            head = deleteDuplicates(head);
        }
        return head;

    }
}


public class Main {
    public static void main(String[] arg) {




    }


}

