
#include <iostream>
using namespace std;

struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 



class Solution {
public:
    int res = 0;    
    int diameterOfBinaryTree(TreeNode* root) { 
        if(root == nullptr) return  0;
        dfs(root);
        return res;
    }
    int dfs(TreeNode *  root ){
        if(root==nullptr){
            return 0;
        }
        int left = dfs(root->left);
        int right = dfs(root->right);
        res = max(res,left+right);
        return max(left,right)+1;
    }
};