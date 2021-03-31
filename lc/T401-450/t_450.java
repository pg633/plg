package leetcoder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root ==null) return null;
        if(root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }else{
                TreeNode t = min(root.right);
                t.right = deleteNode(root.right);
                t.left = root.left ;
                return t;
            }
        }
    }

    private TreeNode deleteNode(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        root.left = deleteNode(root.left);
        return root;
    }

    private TreeNode min(TreeNode root) {
        if(root.left==null) return root;
        return min(root.left);
    }
}
public class AAA {
    public static void main(String[] args) {

    }
}