package leetcoder;

class Solution {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }
    public int getMax(TreeNode t){
        if(t==null) return 0;
        int left = Math.max(0,getMax(t.left));
        int right = Math.max(0,getMax(t.right));
        res = Math.max(res,left+right+t.val);
        return Math.max(left,right)+t.val;
    }
}
