#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
const int mod = (int)1e9+7;

    int checkRecord(int n) {
        vector<int> dp (n,0);
        if(n==0){ 
            return 0;
        }else if (n==1){ 
            return 3;
        }else if(n==2){ 
            return 8;
        }
         dp[0]=0; dp[1]=3;dp[2] =8;
        for(int i=3;i<n;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%mod; 
        }
        int res =(dp[n-1] + dp[n-2] +dp[n-3])%mod;
        for(int i=0;i<n;i++){
            res += (dp[i]*dp[n-1-i])%mod;
            res %=mod;
        }
        return res;
    }
};


int main(){
    Solution s ;
    cout<<s.checkRecord(3)<<endl;;
}