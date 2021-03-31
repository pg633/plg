#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        return travel(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
    TreeNode *travel(vector<int> &preorder, int preL, int preR, vector<int> &inorder, int inL, int inR)
    {
        cout << preL << " " << preR << " " << inL << " " << inR << endl;
        if (preL > preR || inL > inR)
            return nullptr;
        TreeNode *root = new TreeNode(preorder[preL]);
        auto n_pos = 0;
        for (int i = inL; i <= inR; i++)
        {
            if (inorder[i] == preorder[preL])
                n_pos = i - inL;
        }
        // cout<<n_pos;
        // int n;
        // cin>>n;

        root->left = travel(preorder, preL + 1, preL + n_pos, inorder, inL, inL + n_pos - 1);
        root->right = travel(preorder, preL + n_pos + 1, preR, inorder, inL + n_pos + 1, inR);
        return root;
    }
};

void dfs(TreeNode *t)
{
    if (t == nullptr)
        return;
    cout << t->val << " ";
    dfs(t->left);
    dfs(t->right);
}
int main()
{
    Solution s;
    vector<int> v1{1, 2, 3}, v2{3, 2, 1};
    auto l = s.buildTree(v1, v2);
    dfs(l);
}