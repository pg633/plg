package leetcoder;


import java.util.*;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node>  q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Queue<Node>  t = new LinkedList<>();
            List<Integer> now = new ArrayList<>();
            while(!q.isEmpty()){
                Node node = ((LinkedList<Node>) q).pollFirst();
                for (Node child : node.children) {
                    ((LinkedList<Node>) t).add(child);
                }
                now.add(node.val);
            }
            q = t;
            res.add(new ArrayList<>(now));
        }
        return res;
    }
}




public class AAA {
    public static void main(String[] args) {


    }
}
