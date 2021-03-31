class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int,int> m ;
        for(auto var : nums)
        {
            m[var]++;
        }      
        int res = 0;
        for(auto var:m){
            if(m.count(var.first +1) == 1){
                res = max(res,m[var.first] + m[var.first+1]);
            }
        
        }
        return res;
    }
};