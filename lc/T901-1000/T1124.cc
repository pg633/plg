
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int longestWPI(vector<int> &hours)
    {
        int len = hours.size();
        vector<int> pre(len + 1, 0);
        int res = 0;
        for (int i = 0; i < len; i++)
        {
            res += (hours[i] > 8 ? 1 : -1);
            pre[i + 1] = res;
        }
        for (auto it : pre)
        {
            cout << it << " ";
        }
        cout << endl;

        stack<int> s;
        for (int i = 0; i < len; i++)
        {
            if (s.empty() || pre[s.top()] > pre[i])
            {
                s.push(i);
            }
        }

        res = 0;
        for (int i = len - 1; i >= 0 && !s.empty(); i--)
        {
            if (pre[s.top()] < pre[i])
            {
                res = max(res, i - s.top());
                s.pop();
            }
        }
        return res;
    }
};

int main()
{
    vector<int> v{9, 9, 6, 0, 6, 6, 9};
    Solution s;
    cout << s.longestWPI(v);
    return 0;
}