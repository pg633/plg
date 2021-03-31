package leetcoder;


import java.util.List;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        ListNode t = h;
        for(int i=0;i<m-1;i++){
            t.next = head;
            head=head.next;
            t =t.next;
        }
        // swap [m,n]
        ListNode t1 = head;
        ListNode t2 = head;
        head= head.next;
        for(int i=m;i<n;i++){
            ListNode tt = head;
            head = head.next;
            tt.next = t1;
            t1 = tt;
        }
        t.next = t1;
        t2.next = head;
        return h.next;

    }
}



class Main{
    static void  pt (ListNode t){
        while (t!=null){
            System.out.print(t.val+ "    " );
            t =t.next;
        }
        System.out.println();
    }
    public static  void main(String []arg){
        ListNode head = new ListNode(1);
        ListNode t = head;
        for(int i=2;i<10;i++){
            t.next = new ListNode(i);
            t = t.next;
        }
        t.next = null;
        pt (head);

        ListNode p = new leetcoder.Solution().reverseBetween(head,1,4);

        pt (p);

    }
}