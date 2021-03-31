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
    TreeNode *pruneTree(TreeNode *root)
    {
        travel(root);
        return root;
    }
    bool travel(TreeNode *root)
    {
        if (root == nullptr)
            return false;
        bool l = travel(root->left);
        bool r = travel(root->right);

        root->left = l ? root->left : nullptr;
        root->right = r ? root->right : nullptr;
        return root->val == 1 | l | r;
    }
};