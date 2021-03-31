

package leetcoder;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
//
//
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return get(0, inorder.length - 1,0,postorder.length-1,inorder, postorder);
    }

    public TreeNode get(int ll, int lr,int rl,int rr ,int[] inorder, int[] postorder) {
        if( ll > lr  ) return null;

        TreeNode t = new TreeNode(postorder[rr]);
        int index = -1 ;
        for(int i = ll;i<=lr;i++){
            if(inorder[i] == postorder[rr]){
                index = i;
                break;
            }
        }
        if(index==-1) return null;

        t.left = get(ll,index-1,rl,rl+ (index -ll -1),inorder,postorder);
        t.right = get(index+1,lr,rl + (index-ll) ,rr-1,inorder,postorder);
        return t;

    }
}

class Main {
    public static void preTravel(TreeNode t) {
        if (t == null) return;
        System.out.print(t.val);
        preTravel(t.left);
        preTravel(t.right);
    }
    public static void main(String[] arg) {



        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        TreeNode t = new leetcoder.Solution().buildTree(inorder,postorder);
        preTravel(t);
        System.out.println();

    }
}