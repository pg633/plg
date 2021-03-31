package leetcoder;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null) return  null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode head= root.left;
        root.left = root.right;
        root.right = head;
        return root;
    }
}
public class Main {

    public static void main(String[] arg) {

    }

}