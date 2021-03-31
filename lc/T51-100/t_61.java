class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<=0) return head;
        Map<Integer,ListNode> m = new HashMap<>();
        int id= 0;
        while(head!=null){
            m.put(++id,head);
            head=head.next;
        }
        k%=id;
        if(k==0){
            return m.get(1);
        }else{
            ListNode t2 = m.get(id-k+1);
            m.get(id-k).next = null;
            m.get(id).next=m.get(1);
            return t2;
        }
    }
}