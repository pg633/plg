package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Integer [] arr = new Integer[list.size()];
        list.toArray(arr);
        if(arr.length==0) return null;
        return build(arr,0,arr.length-1);
    }
    public TreeNode build(Integer[] arr,int l,int r){
        if(l>r) return null;
        int index = l+r>>1;
        TreeNode t = new TreeNode(arr[index]);
        t.left = build(arr,l,index-1);
        t.right = build(arr,index+1,r);
        return t;
    }
}


