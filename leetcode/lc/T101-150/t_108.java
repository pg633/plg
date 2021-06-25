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
    public TreeNode sortedArrayToBST(int[] nums) {
        //有序数组 抓转二叉树
        // 递归建树
        if(nums.length ==0 ) return null;
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int [] num ,int l,int r){
        if(l>r) return null;
        int mid = l+r>>1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num,l,mid-1);
        root.right = build(num,mid+1,r);
        return root;
    }
}