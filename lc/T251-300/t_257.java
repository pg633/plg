
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res,"",root);
        return res;
    }

    private void dfs(List<String> res, String s, TreeNode root) {
        if(root==null)return ;
        if(s.equals("")){
            s=String.valueOf(root.val);
        }else {
            s+="->"+root.val;
        }
        if(root.left == null && root.right==null){
            res.add(new String(s));
            return;
        }else if(root.left == null){
            dfs(res,s,root.right);
        }else if(root.right == null){
            dfs(res,s,root.left);
        }else {
            dfs(res,s,root.left);
            dfs(res,s,root.right);
        }
    }
}