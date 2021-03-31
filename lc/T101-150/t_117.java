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
            while (!q.isEmpty()){
                TreeLinkNode tmp = q.poll();
                if(tmp.left!=null)   t.add(tmp.left);
                if(tmp.right!=null)   t.add(tmp.right);
            }



            TreeLinkNode last = null;
            for(TreeLinkNode tt : t){
                if(last!=null)
                    last.next = tt;
                last = tt;
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