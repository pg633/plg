package  leetcoder;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null|| n==0 )return head;
        ListNode no = head;
        ListNode t  = head;
        while(--n>=0)
            t =t.next;
        if(t!=null) t=t.next;
        else {
            return head.next;
        }
        while(t!=null)
        {
            t=t.next;
            no=no.next;
        }
        no.next = no.next.next;
        return head;
    }
}