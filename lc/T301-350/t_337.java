package leetcoder;



class Solution {
    public int rob(TreeNode root) {
        if(root == null)return 0;
        int a = 0;
        int b = root.val;
        if(root.left == null && root.right ==null) return b;
        a= a + rob(root.left) + rob(root.right);
        if(root.left!=null){
            b += rob(root.left.left);
            b += rob(root.left.right);
        }
        if(root.right!=null){
            b += rob(root.right.left);
            b += rob(root.right.right);
        }
        return Math.max(a,b);
    }
}


public class AAA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        int rob = new Solution().rob(root);
        System.out.println(rob);
    }
}
