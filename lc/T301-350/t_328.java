
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode t1 = new ListNode(0);
        ListNode t2 = new ListNode(0);
        ListNode h1 = t1;
        ListNode h2 = t2;
        while(head !=null){
            if(head!=null){
                h1.next = head;
                head = head.next;
                h1 = h1.next;
                h1.next = null;
            }
            if(head!=null){
                h2.next = head;
                head = head.next;
                h2 = h2.next;
                h2.next = null;
            }
        }
        h1.next = t2.next;
        return t1.next;
    }
}

