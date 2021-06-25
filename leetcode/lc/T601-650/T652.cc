class Solution
{
public:
    vector<TreeNode *> findDuplicateSubtrees(TreeNode *root)
    {
        vector<TreeNode *> res;
        map<string, int> m;
        if (root == nullptr)
        {
            return res;
        }
        dfs(root,res,m);
        return res;
    }
    string dfs(TreeNode *root,vector<TreeNode *>&res,map<string,int>&m){
        if(root == nullptr) return "";
        stringstream ss ;
        ss<<root->val;
        string ks = ss.str()+","+dfs(root->left,res,m)+","+dfs(root->right,res,m);
        
        m[ks]++;
        if(m[ks]==2 ){
            res.push_back(root);
        }
        return ks;
    }
};

