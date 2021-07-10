
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> v; 
        if(root==nullptr) return v;
        stack<Node * >q ;
        q.push(root);  
        while(!q.empty()){
            Node * t = q.top();
            q.pop();
            v.push_back(t->val);
            for(size_t i = 0; i < t->children.size(); i++)
            {
                q.push(t->children[t->children.size()-1-i]);
                /* code */
            }
            
        }  
        return  v;
    }
};