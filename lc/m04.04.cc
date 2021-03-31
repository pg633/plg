
class Solution
{
public:
    bool is_flag = true;
    bool isBalanced(TreeNode *root)
    {

        travel(root);
        return is_flag;
    }
    int travel(TreeNode *root)
    {
        if (root == nullptr || !is_flag)
            return 0;
        auto l = travel(root->left);
        auto r = travel(root->right);
        if (abs(l - r) > 1)
        {
            is_flag = false;
        }
        return max(l, r) + 1;
    }
};
