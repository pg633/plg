package leetcoder;


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head== null) return null;
        if(head.val == val) return removeElements(head.next,val);
        ListNode listNode = removeElements(head.next, val);
        head.next = listNode;
        return head;
    }
}









public class Main {

    public static void main(String[] arg) {


    }

}