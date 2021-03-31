/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <set>
class Solution
{
public:
    set<int> s;
    bool findTarget(TreeNode *root, int k)
    {
        if (root == NULL)
            return false;
        if (s.count(root->val)==1)
            return true;
        s.insert(k - root->val);
        return findTarget(root->left, k) ||
               findTarget(root->right, k);
    }
};