package leetcoder;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2 ,int t){
        if(l1==null && l2 ==null && t==0) return null;
        if(l1 !=null ){
            t+=l1.val;
        }
        if(l2!=null){
            t+=l2.val;
        }
        ListNode tt = new ListNode(t%10);
        t=t/10;
        ListNode tNext = addTwoNumbers(l1==null?l1:l1.next ,l2==null?l2:l2.next,t );
        tt.next = tNext;
        return tt;
    }
}
public class t_02 {
    public static void main(String []arg){
        String str = "abvdb";
        System.out.println(str.substring(0,1));
    }
}
