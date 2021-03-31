/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    int findSecondMinimumValue(TreeNode *root)
    {
        return dfs(root,root->val);
    }
    int dfs(TreeNode *root,int val){
        if(root == nullptr) return -1;
        if(root->val > val) return root->val;
        int l = dfs(root->left,val);
        int r = dfs(root->right,val);
        if(val < l && val < r) return min(l,r);
        return max(l,r);    
    }
};