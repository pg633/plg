#include <iostream>
#include <string>
#include <vector>
#include<queue>
using namespace std;

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
class Solution {
public:
    int maxDepth(Node* root) {
        if(!root) return 0;
        int res = 0;
        queue<Node*> q ;
        q.push(root); 
        while(!q.empty()){
            res++;
            int len = q.size();
            for(int i=0;i<len;i++){
                Node* t = q.front();q.pop();
                if(t->children.size()>0){
                    for(auto tt:t->children){
                        q.push(tt);
                    }
                }
            }
        }
        return res;
    }
};
int main(){

}