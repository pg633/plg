import leetcoder.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null ) return head;
        ListNode t= head;
        ListNode t2 = head.next;
        ListNode t3 = swapPairs(t2.next);
        t2.next = t;
        t.next = t3;
        return t2;

    }
}
