package leetcoder;


import java.util.*;

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }

    private int sumNumbers(TreeNode root, int n) {
        if(root==null) return n;
        if (root.left==null && root.right==null) return n*10+root.val;
        if(root.left==null || root.right==null){
            return sumNumbers(root.left==null?root.right:root.left,n*10+root.val);
        }
        return sumNumbers(root.left,(n*10+root.val))+sumNumbers(root.right,(n*10+root.val));
    }
}



public class Main {

    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new leetcoder.Solution().sumNumbers(root));
    }

}