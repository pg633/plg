class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode tmp = root.right;
        if(last!=null){
            last.right = root;
        }
        last = root;
        flatten(root.left);
        flatten(tmp);
        root.left=null;

    }
    private TreeNode last = null;
}