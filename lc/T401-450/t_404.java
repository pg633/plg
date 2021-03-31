package leetcoder;


import java.util.*;
class Solution {
    private int res= 0;
    public int sumOfLeftLeaves(TreeNode root) {

        return   dfs(root,false);
    }

    private int dfs(TreeNode root, boolean flag) {
        if(root== null) return 0;
        if(root.left == null && root.right==null){
            if(flag) return root.val;
            else return 0;
        }
        return dfs(root.left,true) +dfs(root.right,false);
    }
}

public class AAA {
    public static void main(String[] args) {

    }
}
