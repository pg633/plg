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
    int pathSum(TreeNode *root, int sum)
    {

        map<int, int> m;
        m[0] = 1;

        return travel(root, m, 0, sum);
    }
    int travel(TreeNode *root, map<int, int> &m, int cur, int sum)
    {
        if (root == nullptr)
            return 0;
        int res = 0;
        cur += root->val;
        res += m[cur - sum];
        m[cur] += 1;
        res += travel(root->left, m, cur, sum);
        res += travel(root->right, m, cur, sum);
        m[cur]--;
        return res;
    }
};
