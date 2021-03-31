package leetcoder;


import java.util.*;

class Solution {
    private Map<Integer,Integer> m = new HashMap();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new LinkedList<>();
        int ans = 0;
        for (Map.Entry<Integer, Integer> ine : m.entrySet()) {
            if(ine.getValue() > ans){
                ans = ine.getValue();
                res.clear();
                res.add(ine.getKey());
            }else if(ine.getValue()==ans){
                res.add(ine.getKey());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int res = l+r+root.val;

        m.put(res,  m.getOrDefault(res,0)+1);
        return res;
    }
}


public class AAA {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(2);
        t.right = new TreeNode(-5);

        int[] frequentTreeSum = new Solution().findFrequentTreeSum(t);
        System.out.println(Arrays.toString(frequentTreeSum ));
    }
}