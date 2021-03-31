 
class Solution {
public:
    int mx = 1 ; 
    int dfs(TreeNode * root,int val){
        if(root == nullptr) return  0;
        int l = dfs(root->left,root->val);
        int r = dfs(root->right,root->val);
        mx = max(mx,l+r+1);
        if(val == root->val){
            return max(l,r) +1 ;
        }else {
            return 0 ;
        }
    }
    int longestUnivaluePath(TreeNode* root) {
        dfs(root,-1);
        return mx-1;
    }
}; 