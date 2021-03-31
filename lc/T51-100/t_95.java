package leetcoder;


import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return dfs(1,n);
    }
    public List<TreeNode> dfs(int l,int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r) {
            res.add(null);
            return res;
        }

        for(int i=l;i<=r;i++){
            List<TreeNode> ll = dfs(l,i-1);
            List<TreeNode> rr = dfs(i+1,r);
            for(TreeNode lt : ll)
                for(TreeNode rt : rr){
                    TreeNode tt = new TreeNode(i);
                    tt.left = lt;
                    tt.right = rt;
                    res.add(tt);
                }

        }
        return  res;
    }
}




class Main {

    public static void pt(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedBlockingQueue<TreeNode>();
        TreeNode t = null;
        q.offer(root);

        while ( !q.isEmpty()){
            t = q.poll();
            System.out.print(t.val + "  ");
            if(t.left!=null)
                q.offer(t.left);
            if(t.right != null) {
                q.offer(t.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] arg) {


        List<TreeNode> ob = new leetcoder.Solution().generateTrees(3);
        for (TreeNode r : ob)
            pt(r);
//            System.out.print(r.val + "        ");


    }
}