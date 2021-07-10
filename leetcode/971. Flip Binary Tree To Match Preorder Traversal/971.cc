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
    vector<int> flipMatchVoyage(TreeNode *root, vector<int> &voyage)
    {
        vector<int> v;
        int num = 0;
        return travel(root, voyage, v, num) ? v : vector<int>{-1};
    }
    bool travel(TreeNode *root, vector<int> &voyage, vector<int> &v, int &index)
    {
        if (root == nullptr || index >= voyage.size())
            return true;

        if (root->val != voyage[index])
            return false;
        ++index;

        if (root->left != nullptr && root->left->val != voyage[index])
        {
            // 可以交换
            v.push_back(root->val);
            return travel(root->right, voyage, v, index) && travel(root->left, voyage, v, index);
        }
        else
        {
            return travel(root->left, voyage, v, index) && travel(root->right, voyage, v, index);
        }
    }
};
