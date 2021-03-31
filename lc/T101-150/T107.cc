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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
      vector<vector<int>> res;
      travel(res,root,0);
      return res;
    }
    void travel(    vector<vector<int>> & res ,TreeNode* root ,int level ){
        if(root==nullptr) return;
        if(res[level].size()==0) res[level] = {};
        res[level].emplace_back(root->val);
         travel(res,root->left,level+1);
         travel(res,root->right,level+1);
        return;
    }
};