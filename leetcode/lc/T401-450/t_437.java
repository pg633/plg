package leetcoder;


import java.util.*;



class Solution {

    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode pop = s.pop();
            count += sum(pop,sum);
            if(pop.left != null)
                s.push(pop.left);
            if(pop.right!=null)
                s.push(pop.right);
        }
        return count;
    }

    private int sum(TreeNode pop, int sum) {
        int count = 0;
        if(pop == null) return 0;
        if(sum == pop.val) count++;
        count+=sum(pop.left,sum-pop.val);
        count+=sum(pop.right,sum-pop.val);
        return count;


    }
}



public class AAA{
    public static void main(String[] args) {

    }
}