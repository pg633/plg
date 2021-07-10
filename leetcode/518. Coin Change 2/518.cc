class Solution {
public:
    int change(int amount, vector<int>& coins) {
        // 5  1 2 5 
        vector<int> dp ( amount+1,INT_MAX);
        dp[0]=1;
        for(auto& i : coins){
            for(int j = 1; j <= amount; j++){
                if(j-i>=0){
                    dp[j] =  dp[j]+dp[j-i];
                }
            }
        }
        return dp[amount];
    }
};