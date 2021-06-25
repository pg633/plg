/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSubtree(TreeNode* s, TreeNode* t) {
        bool res = false;
        if(s!=nullptr && t!=nullptr){
            if(s->val == t->val){
                res = core(s,t);
            }
            if(res == false) res = isSubtree(s->left,t);
            if(res == false) res = isSubtree(s->right,t);
        }
        return res;
    }
    bool core(TreeNode* t1,TreeNode* t2)
    {
        if(t2 == nullptr && t1 != nullptr)
            return false;
        if(t1 == nullptr && t2 != nullptr)
            return false;
        if(t1 == nullptr && t2 == nullptr)
            return true;
        if(t1->val != t2->val)
            return false;
        return core(t1->left,t2->left) && core(t1->right,t2->right);
    }
};