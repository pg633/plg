#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    map<pair<int, int>, int> m;
    int superEggDrop2(int K, int N)
    {
        return dfs(K, N);
    }
    int dfs(int k, int n)
    {
        if (k == 1)
            return n;
        if (n == 0)
            return 0;
        if (m.count({k, n}))
        {
            return m[{k, n}];
        }
        int res = n;
        // for (int i = 1; i <= n; i++)
        // {
        //     res = min(res,
        //               max(dfs(k - 1, i - 1), dfs(k, n - i)) + 1);
        // }
        int lo = 1, hi = n;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            int broker = dfs(k - 1, mid - 1);
            int nbroker = dfs(k, n - mid);
            if (broker > nbroker)
            {
                hi = mid - 1;
                res = min(res, broker + 1);
            }
            else
            {
                lo = mid + 1;
                res = min(res, nbroker + 1);
            }
        }
        m[{k, n}] = res;
        return res;
    }

    int superEggDrop(int K, int N)
    {
        vector<vector<int>> dp(K + 1, vector<int>(N + 1, 0));
        // dp [i][j] 有i 个鸡蛋 ，并且可以仍j 次 ，此时楼是 N 层
        int m = 0;
        while (dp[K][m] < N)
        {
            ++m;
            for (int i = 1; i <= K; i++)
            {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }

        return m;
    }
    int superEggDrops(int K, int N)
    {
        vector<int> dp(K + 1, 0);
        int res = 0;
        while (dp[K] < N)
        {
            ++res;
            for (int i = K; i >= 0; i--)
            {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }
        return res;
    }
};

int main()
{
    Solution s;
    cout << s.superEggDrops(3, 14) << endl;
    return 0;
}