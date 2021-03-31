#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int eraseOverlapIntervals(vector<vector<int>> &intervals)
    {
        sort(intervals.begin(), intervals.end(), [](vector<int> l, vector<int> r) {
            return l[1] < r[1];
        });

        int end = intervals[0][1];
        int res = 1;

        for (int i = 1; i < intervals.size(); i++)
        {
            if (end > intervals[i][0])
                continue;
            end = intervals[i][1];
            res++;
        }

        return intervals.size() - res;
    }
};
int main()
{
}