/*
// Employee info
class Employee {
public:
    // It's the unique ID of each node.
    // unique id of this employee
    int id;
    // the importance value of this employee
    int importance;
    // the id of direct subordinates
    vector<int> subordinates;
};
*/
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        map<int,Employee * > m ;
        for(auto it:employees){
            m[it->id] = it;
        }
        return dfs(m,id);
    }
    int dfs(map<int,Employee*> m ,int id){
        int res = m[id]->importance;
        for(auto it : m[id]->subordinates){
            res+=dfs(m,it);
        }
        return res; 
    }
};