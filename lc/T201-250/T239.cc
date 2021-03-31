
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k)
    {
        vector<int> res;
        min_queue q;
        for (int i = 0; i < nums.size(); i++)
        {
            if (i < k - 1)
            {
                q.push(nums[i]);
            }
            else
            {
                q.push(nums[i]);
                res.push_back(q.max());
                q.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

private:
    class min_queue
    {
    private:
        deque<int> q;

    public:
        void push(int n)
        {
            while (!q.empty() && q.back() < n)
            {
                q.pop_back();
            }
            q.push_back(n);
        }
        int max()
        {
            return q.front();
        }
        void pop(int n)
        {
            if (!q.empty() && q.front() == n)
            {
                q.pop_front();
            }
        }
    };
};