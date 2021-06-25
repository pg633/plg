package leetcoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
    public List<Integer> preTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
//        s.push(root);
        TreeNode t = root;
        while(!s.empty() || t!=null ){
            if(t!=null){
                while(t!=null){
                    s.push(t);
                    list.add(t.val);
                    t =  t.left ;
                }
            }
            if(!s.empty()){
                t = s.pop();
                t = t.right;
            }
        }

        return  list;
    }
    public List<Integer> inTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        TreeNode t = root;
        while(!s.empty() || t!=null ){
            while(t!=null){
                s.push(t);
                t = t.left;
            }
            if(!s.empty()){
                t = s.pop();
                list.add(t.val);
                t = t.right;
            }

        }

        return  list;
    }
    public List<Integer> lastTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode t = root;
        while(!s1.empty() || t!=null){
            while (t!=null){
                s1.push(t);
                s2.push(t);
                t = t.right;
            }
            if(s1!=null){
                t = s1.pop();
                t = t.left;
            }
        }
        while(!s2.empty()){
            list.add(s2.pop().val);
        }
        return list;
    }

    public List<Integer> lasterTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null ,cur = null;
        s.push(root);
        while(!s.empty()){
            cur = s.peek();
            if(pre==null || pre.left == cur || pre.right == cur){
                if(cur.left!=null)
                    s.push(cur.left);
                else if(cur.right!=null)
                    s.push(cur.right);
            }else if(cur.left == pre){
                if(cur.right!=null)
                    s.push(cur.right);
            }else {
                list.add(cur.val);
                s.pop();
            }
            pre = cur;

        }

        return list;
    }






    public void pre(TreeNode treeNode){
        if(treeNode == null ) return;
        System.out.print(treeNode.val + "   ");
        pre(treeNode.left);
        pre(treeNode.right);

    }

    public void mid(TreeNode treeNode){
        if(treeNode == null ) return;
        mid(treeNode.left);
        System.out.print(treeNode.val + "   ");
        mid(treeNode.right);

    }

    public void last(TreeNode treeNode){
        if(treeNode == null ) return;
        last(treeNode.left);
        last(treeNode.right);
        System.out.print(treeNode.val + "   ");

    }



}





class Main{

    public static  void main(String []arg){
        TreeNode head = new TreeNode(1);
        TreeNode head2 = new TreeNode(2);
        TreeNode head3 = new TreeNode(4);
        head.left = null;
        head.right = head2;
        head2.left = head3;
        head2.right = null;
        head3.left = null;
        head3.right = null;


        leetcoder.Solution s = new leetcoder.Solution();


        System.out.print("前序遍历  ");
        s.pre(head);
        System.out.println();


        System.out.print("中序遍历  ");
        s.mid(head);
        System.out.println();

        System.out.print("后序遍历  ");
        s.last(head);
        System.out.println();


        Object ob = new leetcoder.Solution().preTraversal(head);
        System.out.println(ob);

        ob = new leetcoder.Solution().inTraversal(head);
        System.out.println(ob);

        ob = new leetcoder.Solution().lastTraversal(head);
        System.out.println(ob);

        ob = new leetcoder.Solution().lasterTraversal(head);
        System.out.println(ob);








    }
}