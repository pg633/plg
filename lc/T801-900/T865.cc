/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
         TreeNode* tmp = nullptr;
         dfs(root, tmp);

    }
    int dfs(TreeNode* root, TreeNode* &tmp){
        if( root == nullptr) return 0;
        TreeNode* lp;
        TreeNode* rp;
        int l =  dfs(root->left, lp);
        int r =  dfs(root->right, rp);
        if(l==r) tmp = root;
        else if  (l> r) tmp = lp;
        else if (r> l) tmp = rp;
        return max(l,r) + 1;

    }

};