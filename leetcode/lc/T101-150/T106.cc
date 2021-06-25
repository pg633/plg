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
    int pos = 0;
    map<int, int> m;

    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder)
    {

        int id = 0;
        for (auto it : inorder)
        {
            m[it] = id++;
        }
        int now = postorder.size() - 1;
        return travel(inorder, postorder, now, 0, inorder.size() - 1);
    }
    TreeNode *travel(vector<int> &inorder, vector<int> &postorder, int &now, int l, int r)
    {
        cout << " now : " << now << " l: " << l << " r: " << r << "id " << endl;
        if (l > r || now < 0)
            return nullptr;
        TreeNode *root = new TreeNode(postorder[now]);
        auto id = m[postorder[now]];

        now--;
        root->right = travel(inorder, postorder, now, id + 1, r);
        root->left = travel(inorder, postorder, now, l, id - 1);
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

    vector<int> v1{9, 3, 15, 20, 7}, v2{9, 15, 7, 20, 3};
    auto l = s.buildTree(v1, v2);
    dfs(l);
}