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
    int res = 0;
    public int countNodes(TreeNode root) {
        pre(root);
        return res;
    }

    private void pre(TreeNode root) {
        if(root ==null)return;
        res++;
        pre(root.left);
        pre(root.right);
    }

}
public class Main {

    public static void main(String[] arg) {


    }

}