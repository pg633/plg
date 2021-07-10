package leetcoder;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp = head.next;
        while(tmp!=null && tmp.val == head.val)
            tmp = tmp.next;
        head.next = deleteDuplicates(tmp);
        return head;
    }
}


public class Main {
    public static void main(String[] arg) {
        int []  a ={5,1,3};




    }


}

