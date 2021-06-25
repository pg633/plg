#include <bits/stdc++.h>
using namespace std;
// class Solution1
// {
// public:
//     vector<vector<int>> subsets(vector<int> &nums)
//     {
//         vector<vector<int>> res;
//         vector<int> track;
//         dfs(nums, 0, track, res);
//         return res;
//     }
//     void dfs(vector<int> &num, int n, vector<int> &track, vector<vector<int>> &res)
//     {
//         res.push_back(track);
//         for (int i = n; i < num.size(); i++)
//         {
//             track.push_back(num[i]);
//             dfs(num, i + 1, track, res);
//             track.pop_back();
//         }
//     }
// };

// class Solution
// {
// public:
//     vector<vector<int>> subsetsWithDup(vector<int> &nums)
//     {
//         sort(nums.begin(), nums.end());
//         set<vector<int>> res;
//         vector<int> track;
//         dfs(nums, 0, track, res);
//         vector<vector<int>> ress;
//         for (auto &it : res)
//         {
//             ress.push_back(vector<int>(it.begin(), it.end()));
//         }
//         return ress;
//     }
//     void dfs(vector<int> &num, int n, vector<int> &track, set<vector<int>> &res)
//     {
//         res.insert(track);
//         for (int i = n; i < num.size(); i++)
//         {
//             track.push_back(num[i]);
//             dfs(num, i + 1, track, res);
//             track.pop_back();
//         }
//     }
// };


void dfs(int n, int k, int pos,vector<int> track,vector<vector<int>>& res)
{
    if(k == track.size()) {
        res.push_back(track);
        return;
    }
    for(int i = pos;i<=n;i++)
    {
        track.push_back(i);
        dfs(n,k,i+1,track,res);
        track.pop_back();
    }
}

vector<vector<int>> combine(int n, int k)
{
    vector<vector<int>> res;
    if (k <= 0 || n <= 0)
        return res;
    vector<int> track;
    dfs(n,k,1,track,res);
    return res;
}


int main()
{
    auto k = combine(4, 2);
    for (auto it : k)
    {
        for (auto ii : it)
        {
            cout << ii << " ";
        }
        cout << endl;
    }
}