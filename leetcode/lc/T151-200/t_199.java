package leetcoder;

import javax.xml.transform.SourceLocator;
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Deque<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Deque<TreeNode> tmp = new LinkedList<>();
            res.add(Q.peekLast().val);
            while (!Q.isEmpty()){
                TreeNode listNode = Q.pollFirst();
                if(listNode.left!=null)tmp.add(listNode.left);
                if(listNode.right!=null)tmp.add(listNode.right);
            }
            Q=tmp;
        }
        return res;
    }
}





public class Main {

    public static void main(String[] arg) {
        System.out.println("aaaaaaaaaaaaa");
    }

}