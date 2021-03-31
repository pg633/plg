package leetcoder;


import java.util.*;

class Solution {
    private int max= 0;
    private List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        midt(root);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    private int pre =0;
    private int now =0;
    private void midt(TreeNode root  ) {
        if(root==null) return;
        midt(root.left);
        if(now==0){
            now++;
            pre = root.val;

        }else{
            if(pre == root.val){
                now++;

            }else{
                pre = root.val;
                now=1;
            }
        }
        if(now > max){
            res.clear();
            res.add(pre);
            max = now;
        }else if(max ==now){
            res.add(pre);
        }
        midt(root.right);
    }
}



public class AAA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        int[] mode = new Solution().findMode(root);
        for (int i : mode) {
            System.out.println(i);
        }


    }
}