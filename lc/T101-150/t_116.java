package leetcoder;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()){
            Queue<TreeLinkNode> t = new LinkedList<>();
            TreeLinkNode last = null;
            while (!q.isEmpty()){
                TreeLinkNode tmp = q.poll();
                if(last!=null) {
                    last.next = tmp.left;
                }
                if(tmp.left!=null){
                    tmp.left.next = tmp.right;
                    last = tmp.right;
                    t.add(tmp.left);
                    t.add(tmp.right);
                }
            }
            q=t;
        }

    }
}

public class Main {
    public static void main(String[] arg) {

//        System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));



    }

}