package leetcoder;


import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode tmp = head;
        ListNode h1 = new ListNode(0);
        ListNode h1t = h1;
        ListNode h2 = new ListNode(0);
        ListNode h2t = h2;

        while(tmp !=null){
            if(tmp.val < x){
                h1.next = tmp ;
                tmp = tmp.next;
                h1 = h1.next;
                h1.next = null;
            }else {
                h2.next = tmp;
                tmp = tmp .next;
                h2 = h2.next;
                h2.next = null;
            }
            tmp = tmp.next;
        }
        h1.next = h2t.next;
        return h1.next;
    }
}


class Main{
    public static  void main(){

    }
}