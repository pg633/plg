package  leetcoder;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode no = new ListNode(Integer.MIN_VALUE);
        for(int i=0;i<lists.length;i++){
            merge(no,lists[i]);
        }
        return no.next;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> re = new ArrayList<>();
        for(int i=0;i<lists.length ;i++)
        {
            while(lists[i]!=null) {
                re.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode head = new ListNode(1);
        ListNode no = head;
        Collections.sort(re);
        for(int x:re){
            no.next = new ListNode(x);
            no = no.next;
        }
        return head.next;


    }
}


class Solution3 {
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length == 0) return null;
        int len = lists.length;
        int interval = 1;
        while(interval<len){
            for(int i=0;i<len-interval;i+=interval*2)
            {
                lists[i] = merge(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
}


