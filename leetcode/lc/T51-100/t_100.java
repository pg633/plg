package leetcoder;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null)return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

class Main {

    public static void main(String[] arg) {
        TreeNode head = new TreeNode(1);
        TreeNode head1 = new TreeNode(2);
        TreeNode head2 = new TreeNode(3);
        head.left = head1;
        head1.right = head2;


        new leetcoder.Solution().recoverTree(head);


    }
}