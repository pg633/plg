/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> no = new LinkedList<>();
        q.offer(root);
        no.offer(0);
        
        int len =1 ;
        while(!q.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            LinkedList<Integer> no2 = new LinkedList<>();
            while(!q.isEmpty()) {
                Treenode po  =  q.poll();
                int n = no.poll();
                if(po.left != null){
                    tmp.offer(po.left);
                    no2.offer(2*n+1);
                }
                if(po.right != null){
                    tmp.offer(po.right);
                    no2.offer(2*n+2);
                }
            }
            int plen = 0 ; 
            plen = Math.max(plen,no2.size()>0?no2.getLast()-no2.getFirst()+1:0); 
            q = tmp;
            no = no2;
            len = Math.max(len,plen);
        }
        return len;
    }
}