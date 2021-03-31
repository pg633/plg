package leetcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class Solution {
    private int index =0 ;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int left = kthSmallest(root.left,k);
        if(++index == k) return root.val;
        if(k<index) return left;
        return kthSmallest(root.right,k);

    }
}


public class Main {

    public static void main(String[] arg) {
        List<Integer> strings = new leetcoder.Solution().majorityElement(new int[]{3,2,3});
        strings.forEach(System.out::println);
    }

}