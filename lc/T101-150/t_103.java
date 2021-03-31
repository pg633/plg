

package leetcoder;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
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