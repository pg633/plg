#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool stoneGame(vector<int> &piles)
    {
        int len = piles.size();
        vector<vector<pair<int, int>>> dp(len, vector<pair<int, int>>(len, {0, 0}));
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = {piles[i], 0};
        }

        for (int l = 2; l <= len; l++)
        {
            for (int i = 0; i <= len - l; i++)
            {
                int j = l + i - 1;

                int l = piles[i] + dp[i + 1][j].second;
                int r = piles[j] + dp[i][j - 1].second;
                if (l > r)
                {
                    dp[i][j].first = l;
                    dp[i][j].second = dp[i + 1][j].first;
                }
                else
                {
                    dp[i][j].first = r;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }
        return dp[0][len-1].first > dp[0][len-1].second;
    }
};