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
    int longestZigZag(TreeNode *root)
    {
        int mx = 0;
        if (root == nullptr)
            return 0;
        return max(travel(root->left, 0, 1), travel(root->right, 1, 1));
        ;
    }
    int travel(TreeNode *root, int l_flag, int depth)
    {
        if (root == nullptr)
            return depth - 1;

        if (l_flag)
        {
            return max(travel(root->left, l_flag ^ 1, depth + 1),
                       travel(root->right, 1, 1););
        }
        else
        {
            return max(travel(root->right, l_flag ^ 1, depth + 1),
                       travel(root->left, 0, 1));
        }
    }
};