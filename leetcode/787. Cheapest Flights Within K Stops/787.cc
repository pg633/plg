#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findCheapestPrice(int n, vector<vector<int>> &flights, int src, int dst, int K)
    {

        vector<vector<int>> dp(n, vector<int>(K + 2, INT_MAX));
        fill(dp[src].begin(), dp[src].end(), 0);
        for (int i = 1; i <= K + 1; i++)
        {
            for (auto it : flights)
            {
                if (dp[it[0]][i - 1] != INT_MAX)
                {
                    dp[it[1]][i] = min(dp[it[1]][i], dp[it[0]][i - 1] + it[2]);
                }
            }
        }
        return dp[dst][K + 1];
    }
};

int main()
{
    Solution s;
    vector<vector<int>> v{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    cout<< s.findCheapestPrice(3, v, 0, 2, 1) <<endl;
}