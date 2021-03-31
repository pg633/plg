package leetcoder;


import java.util.Stack;
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int k1 - 0;
        int k2 - 0;
        while(t1!=null){k1++; t1 =t1.next;}
        while(t2!=null){k2++; t2 =t2.next;}
        if(k1>k2){
            int k3 = k1 - k2 ;
            while (k3--!=0){
                headA = headA.next;
            }
        }else if(k2>k1){
            int k3 = k2  - k1  ;
            while (k3--!=0){
                headB = headB.next;
            }
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {

        if(headA==null ||headB==null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 !=p2){
            p1 = p1==null? headB:p1.next;
            p2 = p2==null? headA:p2.next;
        }
        return p1;
    }
}











public class Main {

    public static void main(String[] arg) {


    }

}