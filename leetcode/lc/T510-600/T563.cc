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
    int sum = 0;
    int findTilt(TreeNode* root) {
        last(root);
        return sum;
    }
    int last(TreeNode* root) {
        if(!root) return 0;
        int left = last(root->left);
        int right = last(root->right);
        sum+=abs(left - right);
        return root->val + left + right ;
    }
     
};