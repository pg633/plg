class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
         vector<int> ret;
         vector<int> node (2222,0);
         for (size_t i = 0; i < 2222; i++)
            node[i] = i;
         
         for(auto it:edges){
             int u = it[0];
             int v = it[1];
             while(u!=node[u]) {
                 u = node[u];
             }
             while (v!=node[v]) {
                 v = node[v];
             }
             if(u==v) ret = it;
             node[u] =v;
             
         }
         return ret;
    }
};