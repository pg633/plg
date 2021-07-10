#include <iostream>
#include <vector> 
#include <cmath>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        std::vector<int> v;
        dfs(v,root);
        sort(v.begin(),v.end());
       
        if(v.size()==1) return 0;
        int res = INT_MAX;
        for(int i=0;i<v.size()-1;i++){
            res = min(res,v[i+1]-v[i]);
        }
        return res;

    }
    void dfs(std::vector<int> & v ,TreeNode * root ){
        if(!root) return ;
        v.push_back(root->val);
        dfs(v,root->left);
        dfs(v,root->right);
    }
};