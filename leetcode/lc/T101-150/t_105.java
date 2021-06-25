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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        TreeNode root = new TreeNode(preorder[0]);

        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                int [] pre1 = new int [i];
                int [] pre2 = new int [preorder.length-1-i];
                int [] in1 = new int [i];
                int [] in2 = new int [preorder.length-1-i];
                for(int j=1;j<=i;j++){
                    pre1[j-1] = preorder[j];
                }
                for(int j = i+1;j<preorder.length;j++){
                    pre2[j-i-1] = preorder[j];
                }
                for(int j=0;j<i;j++){
                    in1[j] = inorder[j];
                }
                for(int j = i+1;j<preorder.length;j++){
                    in2[j-i-1] = inorder[j];
                }
                TreeNode left = buildTree(pre1,in1);
                TreeNode right = buildTree(pre2,in2);
                root.left = left;
                root.right = right;
                return root;
            }
        }
        return root;
    }
}

}