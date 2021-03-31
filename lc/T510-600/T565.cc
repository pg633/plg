#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int mm =0;
    int arrayNesting(vector<int>& nums) {
        vector<bool> v (nums.size(),false); 
        for(int i=0;i<nums.size();i++){
            if(!v[i]){ 
                dfs(v,nums,i);
            }
        }        
        return mm;
    }
    void dfs(vector<bool> & vis,vector<int>& nums,int i){
        int res = 0;
        vis[i] = true;
        while(vis[nums[i]] == false) {
            vis[nums[i]] = true;
            i = nums[i];
            res++;
        }
        mm =max(mm,res);
        return ;
    }
};