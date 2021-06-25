

package leetcoder;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Stack<List<Integer>> s = new Stack<>();
        while(!q.isEmpty()){
            List<Integer> lis = new ArrayList<>();
            Queue<TreeNode> t = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode tmp = ((LinkedList<TreeNode>) q).pollFirst();
                lis.add(tmp.val);
                if(tmp.left  !=null)
                    t.add(tmp.left);

                if(tmp.right !=null)
                    t.add(tmp.right);

            }
            s.push(lis);
            q=t;
        }
        while(!s.empty()){
            list.add(s.pop());
        }
        return list ;


    }
}
















class Main {

    public static void main(String[] arg) {

        TreeNode head = new TreeNode(1);
        TreeNode head1 = new TreeNode(2);
        TreeNode head2 = new TreeNode(3);
        head.left = head1;
        head1.right = head2;
        new leetcoder.Solution().levelOrderBottom(head);



    }
}