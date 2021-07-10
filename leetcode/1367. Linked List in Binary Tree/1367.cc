/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    bool isSubPath(ListNode* head, TreeNode* root) {
        if(head==nullptr) return true;
        if(root ==nullptr ) return false;
        return  travel(head,root) || isSubPath(head,root->left) || isSubPath(head,root->right);
    }
    bool travel(ListNode* head, TreeNode* root) {
       if( head==nullptr) return true;
       if( root == nullptr) return false;
       return head->val == root->val && (travel(head->next,root->left) ||travel(head->next,root->right) );

    }
};