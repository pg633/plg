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
    TreeNode *constructMaximumBinaryTree(vector<int> &nums)
    {
        return construct(nums.begin(), nums.end());
    }

private:
    TreeNode *construct(vector<int>::iterator l, vector<int>::iterator r)
    {
        if (l == r)
            return nullptr;
        auto k = max_element(l, r);
        TreeNode *t = new TreeNode(*k);
        t->left = construct(l, k);
        t->right = construct(k + 1, r);
        return t;
    }
};
