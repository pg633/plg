package leetcoder;


import java.util.*;



class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root ==null)return list;
        Stack<TreeNode> s = new Stack<>();

        TreeNode t = root;
        while(!s.isEmpty()||t!=null){
            while(t!=null){
                list.add(t.val);
                s.push(t);
                t=t.left;
            }
            t = s.pop().right;
        }
        return list;
    }
}




public class Main {

    public static void main(String[] arg) {
        TreeNode head = new TreeNode(1);
        head.left = null;
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);

        List<Integer> list = new leetcoder.Solution().preorderTraversal(head);
        list.forEach(System.out::println);

    }

}