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
    vector<vector<string>> printTree(TreeNode *root)
    {
        int height = getHeight(root);
        int weight = pow(2, height) - 1;
        vector<vector<string>> v(height, vector<string>(weight, ""));
        dfsFill(v, root, 0, 0, weight - 1);
        return v;
    }

private:
    void dfsFill(vector<vector<string>> &res, TreeNode *root, int level, int l, int r)
    {
        if (root == nullptr || l > r)
            return;
        int mid = l + r >> 1;
        res[level][mid] = to_string(root->val);
        dfsFill(res, root->left, level + 1, l, mid - 1);
        dfsFill(res, root->right, level + 1, mid + 1, r);
    }
    int getHeight(TreeNode *root)
    {
        if (root == nullptr)
            return 0;
        return max(getHeight(root->left), getHeight(root->right)) + 1;
    }
};
