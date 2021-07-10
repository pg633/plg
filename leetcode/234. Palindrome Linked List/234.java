package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while (slow!= null){
            if(head.val!=slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode next) {
        if(next.next == null) return next;
        ListNode head = reverse(next.next);
        next.next.next =next;
        next.next = null;
        return head;
    }
}



public class Main {

    public static void main(String[] arg) {
        System.out.println(new leetcoder.Solution().countDigitOne(13));;
    }

}