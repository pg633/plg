package leetcoder;





class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;
        return listNode;
    }
}








public class Main {

    public static void main(String[] arg) {


    }

}