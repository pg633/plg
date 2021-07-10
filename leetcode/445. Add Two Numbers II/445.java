package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        return reverse(add(t1,t2,0));
    }

    private ListNode add(ListNode t1, ListNode t2, int i) {
        if(t1==null && t2== null){
            if(i ==0) return null;
            else return new ListNode(i);
        }
        int sum = (t1==null?0:t1.val)+(t2==null?0:t2.val)+i;
        ListNode root = new ListNode(sum%10);
        root.next = add(t1==null?t1:t1.next , t2==null?t2:t2.next,sum/10);
        return root;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }
}
public class AAA {
    public static void main(String[] args) {

    }
}