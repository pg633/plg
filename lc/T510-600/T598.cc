class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        for(auto var : ops)
        {
            m = min(m,var[0]);
            n = min(n,var[1]);
        }
        return m*n;
    }
};