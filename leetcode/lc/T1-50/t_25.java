package  leetcoder;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null)return null;
        Stack<ListNode> s=new Stack<>();
        ListNode t = head;
        for(int i =0;i<k;i++){
            s.push(t);
            if(t !=null) t=t.next;
            else return head ;
        }
        ListNode end = reverseKGroup(t,k);;
        ListNode thead = s.pop();
        t = thead;
        while(!s.empty()){
            t.next = s.pop();
            t =t.next;
        }
        t.next = end;
        return thead;
    }
}