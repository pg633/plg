package leetcoder;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root ==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> tt = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode t = q.poll();
                tmp.add(t.val);
                if(t.left!=null)
                    ((LinkedList<TreeNode>) tt).add(t.left);
                if(t.right!=null)
                    ((LinkedList<TreeNode>) tt).add(t.right);

            }
            q = tt;
            list.add(tmp);
        }
        return list;

    }
}




class Main {

    public static void main(String[] arg) {
        TreeNode head = new TreeNode(1);
        TreeNode head1 = new TreeNode(2);
        TreeNode head2 = new TreeNode(3);
        head.left = head1;
        head1.right = head2;

    }
}


