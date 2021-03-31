

import leetcoder.TreeNode;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,new ArrayList<>(), root,0,sum);
        return list;
    }
    public void dfs(List<List<Integer>> list ,List<Integer> t,TreeNode root,int now,int sum){
        if(root ==null) return;
        now += root.val;
        t.add(root.val);
        if(root.left==null && root.right==null && now ==sum){
            list.add(new ArrayList<>(t));
        }else{
            if(root.left!=null){
                dfs(list,t,root.left,now,sum);
            }
            if(root.right!=null){
                dfs(list,t,root.right,now,sum);
            }
        }
        if(t.size()>0){
            t.remove(t.size()-1);
        }
    }
}
