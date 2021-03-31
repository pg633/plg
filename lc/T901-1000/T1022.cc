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
    int mod = (int)1e9 + 7;
    int sumRootToLeaf(TreeNode *root)
    {
        int sum = 0;

        dfs(root, sum, 0);
        return sum;
    }
    void dfs(TreeNode *t, int &s, int now)
    {
        if (t == NULL)
        {
            return;
        }
        now = now * 2 + t->val;
        if (t->left == nullptr && t->right == nullptr)
            s = (s + now + mod) % mod;
        dfs(t->left, s, now);
        dfs(t->right, s, now);
    }
};
