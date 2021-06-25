#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxSubArray1(vector<int> &nums)
    {
        vector<int> dp(nums.size(), nums[0]);
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        }
        int ans = INT_MIN;
        for (int i = 0; i < nums.size(); i++)
        {
            ans = max(ans, dp[i]);
        }
        return ans;
    }

    int maxSubArray2(vector<int> &nums)
    {
        vector<int> dp(nums.size(), nums[0]);
        dp[0] = nums[0];
        int ans = INT_MIN;
        for (int i = 1; i < nums.size(); i++)
        {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
            ans = max(ans, dp[i]);
        }
        return ans;
    }
    int maxSubArray(vector<int> &nums)
    {
        vector<int> dp(nums.size(), nums[0]);
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        }
        return  *max_element(dp.begin(),dp.end());
    }
};

int main()
{
    // std::vector<double> v{1.0, 2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0, 4.0, 5.0};

    // std::vector<double>::iterator biggest = std::max_element(std::begin(v), std::end(v));
    // //or std::vector<double>::iterator biggest = std::max_element(v.begin(), v.end);

    // std::cout << "Max element is " << *biggest << " at position " << std::distance(std::begin(v), biggest) << std::endl;
    // //另一方面，取最大位置也可以这样来写：
    // //int nPos = (int)(std::max_element(v.begin(), v.end()) - (v.begin());
    // //效果和采用distance(...)函数效果一致
    // //说明：max_element(v.begin(), v.end()) 返回的是vector<double>::iterator,
    // //相当于指针的位置，减去初始指针的位置结果即为最大值得索引。

    // auto smallest = std::min_element(std::begin(v), std::end(v));
    // std::cout << "min element is " << *smallest << " at position " << std::distance(std::begin(v), smallest) << std::endl;
}
