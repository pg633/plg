package leetcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedBlockingQueue<>();
        q.offer(root);
        while(!q.isEmpty()){
            Queue<TreeNode> tmp = new LinkedBlockingQueue<>();
            List<Integer> ll = new ArrayList<>();
            while(!q.isEmpty()){
                TreeNode t = q.poll();
                if(t.left!=null)
                    ((LinkedBlockingQueue<TreeNode>) tmp).offer(t.left);
                if(t.right!=null)
                    ((LinkedBlockingQueue<TreeNode>) tmp).offer(t.right);
                ll.add(t.val);
            }
            list.add(new ArrayList<>(ll));
            q = tmp;
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