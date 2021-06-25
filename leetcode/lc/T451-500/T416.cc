class Solution {
public:
    bool canPartition(vector<int>& nums) {
        auto  sum = accumulate(nums.begin(), nums.end(),0);
        if(sum&1){
            return false;
        }
        sum>>=1;
        vector<int> dp(sum+1,0);
        dp[0]= 1;
        for(auto it :nums){
            for(int j=sum;j>=1;j--){
                if(j-it>=0 && dp[j-it]>0){
                    dp[j] = 1;
                }
            }
        }
        return dp[sum];

    }
};