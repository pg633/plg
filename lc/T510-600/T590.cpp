/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> v;
        if(root==nullptr) return v;
        stack<Node * >s;
        s.push(root);
        while(!s.empty()){
            auto t = s.top();
            s.pop();
            auto arr = t->children;
            for(size_t i = 0; i < arr.size(); i++)
            {
                auto & r = arr[i];
                s.push(r);
            }
            v.push_back(t->val);
        }
        reverse(v.begin(),v.end());
        return v;
    }
};