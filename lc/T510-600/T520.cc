#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;
struct TreeNode {
    int val;
    TreeNode * left,*right;
    TreeNode(int val){
        this->val = val;
        left = nullptr;
        right = nullptr;
    }
};

void pretravel(TreeNode * root){
    if(!root) return;
    cout<<root->val<<endl;
    pretravel(root->left);
    pretravel(root->right);
}
void preTravel(TreeNode* root){
     if(root == nullptr) return;
     stack<TreeNode * >s ;
     s.push(root);
    stack<int> s2;
    while(!s.empty()){
        TreeNode * tmp = s.top();
        if(!tmp->left) s.push(tmp->left);
        if(!tmp->right) s.push(tmp->right);
        s2.push(tmp->val);
    }
    while(!s2.empty()){
       // v.push_back(s2.top());
        cout<<s2.top()<<endl;
        s2.pop();
    }
    return; 
}
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> v;
        if(root == nullptr) return v;
        TreeNode * t = root;
        stack<TreeNode* >s;
        while(!s.empty()){
            TreeNode * tmp = s.top();
           
           
            if(!tmp->left) {
                s.push(tmp->left);
                tmp->left = nullptr;
            }
            if(!tmp->right){
                s.push(tmp->right);
                tmp->right = nullptr;
            }
            else {
                v.push_back(tmp->val);
                s.pop();
            }


        }
         return v;
    }
};




 vector<int> func(TreeNode* root) {
        vector<int> v;
        if(!root) return  v;
        stack<TreeNode*> s;
        while(!s.empty()){
            root = s.top();
            s.pop();
            v.push_back(root->val);
            if(!root->left) s.push(root->left);
            if(!root->right) s.push(root->right);
        }
        reverse(v.begin(),v.end());
        return v;
         
}


class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if(!root)  return {};
        vector<int> v;
        stack<TreeNode * > s;
        s.push(root);
        while(!s.empty()){
            TreeNode * tmp = s.top();
            s.pop();
            v.push_back(tmp->val);
            if(!tmp->left) s.push(tmp->left);
            if(!tmp->right) s.push(tmp=>right);
        }
        return v;
    }
};
int main(){
  TreeNode * head = new TreeNode (1);
  head->left = new TreeNode(2);
  head->right = new TreeNode(3);
//   preTravel(head);
    //vector<int> v {1,2,3,4,5,56,6,7,8};
    Solution s;
    auto v = s.postorderTraversal(head);
    for(auto &tt :v)
        cout<<tt<<endl;

}

