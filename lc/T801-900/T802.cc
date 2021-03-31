
#include <iostream>
#include <vector>
#include <set>
#include <queue>
using namespace std;


class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();

        vector<int> outDegree(n, 0);  
        vector<vector<int>> revGraph(n, vector<int>{});
        vector<int> ans;
        for (int i =0; i < n; i++){
            outDegree[i] = graph[i].size();
            for (auto &end : graph[i]){
                revGraph[end].push_back(i);
            }
        }
        queue<int> q;
        for (int i =0; i< n ; i++){
            if (outDegree[i] == 0) q.push(i);
        }
        while (!q.empty()){
            int f = q.front();
            ans.push_back(f);
            q.pop();
            for (auto start: revGraph[f]){
                outDegree[start]--;
                if (outDegree[start] == 0) q.push(start);
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};


