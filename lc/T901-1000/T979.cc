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
    int distributeCoins(TreeNode* root) {
        int res = 0 ;
        travel(root,res);
        return res;

    }
    int travel(TreeNode* root ,int & n){
        if(root==nullptr) return 0;
        auto l = travel(root->left,n);
        auto r = travel(root->right,n);
        n+= abs(l) + abs(r);
        return root->val +    l+r -1;
    }
};