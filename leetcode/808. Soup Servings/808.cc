

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    double largestSumOfAverages(vector<int> &A, int K)
    {
        int len = A.size();
        if (len <= K)
            return accumulate(A.begin(), A.end(), 0);
        vector<double> v;
        double res = 0.0;
        for (int i = 0; i < len; i++)
        {
            res += A[i];
            v.emplace_back(res);
        }



        vector<vector<double>> dp(len+1, vector<double>(K + 1, 0.0));

        for (int i = 1; i <=len; i++)
        {
            dp[i][1] = (v[i] ) / double(i);
        }
        for (int k = 2; k <=K ; k++)
        {
            for (int i = k; i <= len; i++)
            {
                for (int j = i + 1; j < len; j++)
                {

                    dp[i][k] = max(dp[i][k], dp[j][k - 1] + (v[j] - v[i]) / (j - i));
                }
            }
        }
        return dp[len-1][K-1];


        //   for i in range(1, N+1):
        //     dp[1][i] = avg(0, i)
        // for k in range(2, K+1):
        //     for i in range(k, N+1):
        //         for j in range(k-1, i):
        //             dp[k][i] = max(dp[k][i], dp[k-1][j] + avg(j, i))
        // return dp[-1][-1]




    }
};

int main()
{   
    vector<int> v { 9,1,2,3,9};
    Solution s;
    cout<< s.largestSumOfAverages(v,3)<<endl;
    return  0;

}