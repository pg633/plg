#include <iostream>
#include <string>
#include <vector>
#include <string.h>
using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
       int n = word1.length();
       int m = word2.length();
       int dp [n+1][m+1]={{0}};
       memset(dp,0,sizeof(dp));
       for(size_t i = 0; i < n; i++)
       {
           for(size_t j = 0; j < m; j++)
           {
               if(word1[i] == word2[j])
                    dp[i+1][j+1] = dp[i][j] +1;
                else 
                    dp[i+1][j+1] = max(dp[i][j+1],dp[i+1][j]); 
               /* code */
           }
           /* code */
       }
       return n+m-2*dp[n][m];
    }
};


int main(){
    Solution s; 
    int  a = s.minDistance("eat","sea");
    cout<<a<<endl;
    cout<<"aaaaaaa"<<endl;
}