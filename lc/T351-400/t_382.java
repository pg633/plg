package leetcoder;


import java.util.*;

class Solution {
    private ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val;
        ListNode no = head.next;
        int i = 2;
        Random random = new Random();
        while(no!=null){
            if(random.nextInt(i) == 0){
                res = no.val;
            }
            i++;
            no = no.next;
        }
        return res;

    }
}

public class AAA {
    public static void main(String[] args) {


    }
}
