package leetcoder;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int maxDepth(TreeNode t ){
        if(t==null) return 0;
        else return Math.max(maxDepth(t.left),maxDepth(t.right))+1;
    }
}


class Main {

    public static void main(String[] arg) {





    }
}