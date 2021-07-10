#include <iostream>
#include <string>
#include <sstream>
using namespace std;


 
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int sum = 0;
    TreeNode* convertBST(TreeNode* root) {
        dfs(root); 
        return root ;
    }
    void dfs(TreeNode * root ){
        if(!root) return ; 
        dfs(root->right); 
        root->val += sum;
        sum=root->val;
        dfs(root->left); 
    }
};