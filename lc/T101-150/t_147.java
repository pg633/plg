package leetcoder;


import java.util.*;


class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head ==null ||head.next==null) return head;
        ListNode tHead= new ListNode(0);
        tHead.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur!=null){
            ListNode insertNode = find(tHead, cur);
            if(insertNode ==pre){
                pre = cur;
                cur= cur.next;
            }else{
                pre.next = cur.next;
                cur.next = insertNode.next ;
                insertNode.next = cur;
                cur = pre.next;
            }
        }
        return tHead.next;
    }

    private ListNode find(ListNode t, ListNode cur) {
        while(t.next!=cur){
            if(t.next.val >= cur.val){
                return t;
            }
            t = t.next;
        }
        return t;
    }
}



public class Main {

    public static void main(String[] arg) {


    }

}