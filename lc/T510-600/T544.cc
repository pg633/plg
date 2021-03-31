#include <iostream>
#include <vector>
#include <map>
using namespace std;



class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) { 
        
        map<int,int> m;
        for(auto & v : wall){
            for(int i=0;i<v.size();i++){
                v[i]+=i!=0?0:v[i-1];
                m[v[i]]++;    
            }
        }
        vector<pair<int,int>> v (m.begin(),m.end());
        sort(v.begin(),v.end(),[](pair<int,int> &l,pair<int,int> &r){
            return l.second > r.second;
        });
        return wall.size()-v[0].second;
    }
};

int main(){
    vector<vector<int>> dp  {{1,2,2,1},
        {3,1,2},
        {1,3,2},
        {2,4},
        {3,1,2},
        {1,3,1,1}};
    Solution s;
    cout<< s.leastBricks(dp)<<endl;


}