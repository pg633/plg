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
    TreeNode *recoverFromPreorder(string S)
    {
        TreeNode *root = nullptr;
        travel(S, 0, S.size() - 1, root, 0);
        return root;
    }
    int travel(string &s, int l, int r, TreeNode *&root, int depth)
    {
        int gree = 0;
        int pos = l;
        while (pos <= r && s[pos] == '-')
        {
            gree++;
            pos++;
        }
        // 深度
        if (gree == depth)
        {
            //拼接对象
            string tt;
            while (pos <= r && s[pos] != '-')
            {
               
                tt = tt + s[pos]; pos++;
            }
            root = new TreeNode(stoi(tt));
            if (pos >= r)
                return r;
            int cur_pos = travel(s, pos , r, root->left, depth + 1);
            if (cur_pos < r)
            {
               return  travel(s, cur_pos , r, root->right, depth + 1);
            }
            return r;
        }
        else
        {
            return l;
        }
    }
};

void dfs(TreeNode *root){
    if(root){
        cout<< root->val << " ";
        dfs(root->left);
        dfs(root->right);
    }
}
 
int main()
{
    string k = "1-2--3--4-5--6--7";
    Solution s;
    TreeNode *t = s.recoverFromPreorder(k);
    dfs(t);
}
