#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxCoins(vector<int> nums)
    {
        vector<int> v;
        v.emplace_back(1);
        for (auto it : nums)
            v.emplace_back(it);
        v.emplace_back(1);

        int len = v.size();
        vector<vector<int>> dp(len, vector<int>(len, 0));
        for (int i = nums.size(); i >= 0; i--)
            for (int j = i + 1; j < len; j++)
                for (int k = i + 1; k < j; k++)
                {
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + v[i] * v[k] * v[j]);
                }

        return dp[0][len - 1];
    }
};
int main()
{
    Solution s;

    cout
        << s.maxCoins({3, 1, 5, 8}) << endl;

    int n = 5;
    // 斜着遍历数组
    for (int l = 2; l <= n; l++)
    {
        for (int i = 0; i <= n - l; i++)
        {
            int j = l + i - 1;
            // 计算 dp[i][j]
            cout << i << " " << j << " ";
        }
        cout << endl;
    }
}