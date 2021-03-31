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
    TreeNode *constructFromPrePost(vector<int> &pre, vector<int> &post)
    {
        return dfs(pre, post, 0, pre.size() - 1, 0, pre.size() - 1);
    }
    TreeNode *dfs(vector<int> &pre, vector<int> &post,
                  int ll, int lr, int rl, int rr)
    {
        if (ll > lr || rl > rr)
        {
            return nullptr;
        }

        TreeNode *root = new TreeNode(pre[ll]);
        for (int i = rl; i <= rr; i++)
        {
            if (post[i] == pre[ll + 1])
            {
                root->left = dfs(pre, post, ll + 1, ll + i - rl + 1, rl, i);
                root->right =
                    dfs(pre, post, ll + i - rl + 2, lr, i + 1, rr-1);
                    break;
            }
        }
        return root;
    }
};