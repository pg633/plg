package  leetcoder;

import java.util.List;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null )
            return l2;
        if(l2==null)
            return l1;
        ListNode t1 =  new ListNode(1);
        ListNode t = t1;
        while(l1!=null &&l2!=null){
            if(l1.val<=l2.val)
            {
                t.next = l1;
                l1 = l1.next;
                t=t.next;
                t.next = null;
            }
            else {
                t.next =l2;
                l2 = l2.next;
                t=t.next;
                t.next = null;
            }
        }
        if(l1!=null)t.next =l1;
        else if(l2!=null) t.next = l2;
        return t1.next;
    }
}
