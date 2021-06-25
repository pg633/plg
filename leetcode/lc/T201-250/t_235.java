package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class Solution {
    private  TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return res;
    }

    private void lca(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val - p.val) * (root.val-q.val) <=0){
            res = root;
        }else if((root.val < p.val) && (root.val < q.val)) {
            lca(root.right,p,q);
        }else {
            lca(root.left,p,q);
        }
    }
}




public class Main {

    public static void main(String[] arg) {
        System.out.println(new leetcoder.Solution().countDigitOne(13));;
    }

}