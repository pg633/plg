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
    void dfs(TreeNode *root, TreeNode *target, map<TreeNode *, TreeNode *> &parent)
    {
        if (root != nullptr)
        {
            parent[root] = target;
            dfs(root->left, root, parent);
            dfs(root->right, root, parent);
        }
    }
    vector<int> distanceK(TreeNode *root, TreeNode *target, int K)
    {
        map<TreeNode *, TreeNode *> parent;
        dfs(root, nullptr, parent);
        // 构造父指针

        queue<TreeNode *> q;
        q.push(target);
        vector<int> res;
        set<TreeNode *> vis;
        for (int j = 0; j < K - 1; j++)
        {
            int len = q.size();
            for (int i = 0; i < len; i++)
            {
                TreeNode *it = q.front();
                q.pop();

                if (it->left && vis.count(it->left) == 0)
                {
                    vis.insert(it->left);
                    q.push(it->left);
                }
                if (it->right && vis.count(it->right) == 0)
                {
                    vis.insert(it->right);
                    q.push(it->right);
                }
                if (parent[it] && vis.count(parent[it]) == 0)
                {
                    vis.insert(parent[it]);
                    q.push(parent[it]);
                }
            }
        }
        while (!q.empty())
        {
            res.emplace_back(q.front()->val);
            q.pop();
        }
        return res;
    }
};

int main()
{

    map<int, int> m;
    m[1] = 10;
    for (auto it : m)
    {
        cout << (*it)->first << "" << endl;
    }
}