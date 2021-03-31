class Solution1
{
public:
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0)
            return 0;
        vector<vector<int>> dp(prices.size(), vector<int>(2, 0));

        for (int i = 0; i < prices.size(); i++)
        {
            if (i == 0)
            {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.size() - 1][0];
    }
};

class Solution2
{
public:
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0)
            return 0;
        vector<vector<int>> dp(prices.size(), vector<int>(2, 0));

        for (int i = 0; i < prices.size(); i++)
        {
            if (i == 0)
            {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.size() - 1][0];
    }
};

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int len = prices.size();
        if (len == 0)
            return 0;
        vector<vector<vector<int>>> dp(len, vector<vector<int>>(3, vector<int>(2, 0)));

        for (int i = 0; i < len; i++)
        {
            for (int k = 2; k >= 1; k--)
            {

                if (i == 0)
                {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }
};

class Solution
{
public:
    int maxProfit(int maxk, vector<int> &prices)
    {
        int len = prices.size();
        if (len == 0)
            return 0;
        if (maxk >= prices.size() / 2)
        {
            return maxProfit(prices);
        }
        vector<vector<vector<int>>> dp(len, vector<vector<int>>(maxk + 1, vector<int>(2, 0)));

        for (int i = 0; i < len; i++)
        {
            for (int k = maxk; k >= 1; k--)
            {

                if (i == 0)
                {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][maxk][0];
    }
    int maxProfit(vector<int> &prices)
    {
        if (prices.size() == 0)
            return 0;
        vector<vector<int>> dp(prices.size(), vector<int>(2, 0));

        for (int i = 0; i < prices.size(); i++)
        {
            if (i == 0)
            {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.size() - 1][0];
    }
};

// 309 冷却期
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int len = prices.size();
        if (len == 0)
            return 0;
        vector<vector<int>> dp(len, vector<int>(2, 0));
        for (int i = 0; i < len; i++)
        {
            if (i == 0)
            {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i == 1)
            {
                dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            else
            {

                dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[len - 1][0];
    }
};

//手续费
class Solution
{
public:
    int maxProfit(vector<int> &prices, int fee)
    {
        int len = prices.size();
        if (len == 0)
            return 0;
        vector<vector<int>> dp(len, vector <int>(2, 0));
        for (int i = 0; i < len; i++)
        {
            if (i == 0)
            {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
};
