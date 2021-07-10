package leetcoder;

import java.util.*;

class BSTIterator {

    public BSTIterator(TreeNode root) {
        this.root = root;
        pt(this.root);
    }

    private void pt(TreeNode root) {
        if(root== null)return;
        pt(root.left);
        list.add(root);
        pt(root.right);


    }

    /** @return the next smallest number */
    public int next() {
        return list.get(size++).val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return size < list.size();
    }
    private TreeNode root;
    private List<TreeNode> list = new ArrayList<>();
    private int size =0;
}





public class Main {

    public static void main(String[] arg){


    }

}