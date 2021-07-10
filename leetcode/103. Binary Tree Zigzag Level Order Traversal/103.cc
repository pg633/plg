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
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        vector<vector<int>> res;
        queue<TreeNode *> q;
        q.push(root);
        int level = 0;
        while (!q.empty())
        {
            int len = q.size();
            vector<int> v;
            for (int i = 0; i < len; i++)
            {
                auto it = q.front();
                q.pop();

                if (it == nullptr)
                    continue;
                v.emplace_back(it->val);
                if (it->left)
                    q.push(it->left);
                if (it->right)
                    q.push(it->right);
            }
            if (v.size() != 0)
            {
                if (level % 2 == 1)
                {
                    reverse(v.begin(), v.end());
                }
                res.emplace_back(v);
            }

            level++;
        }
        return res;
    }
};