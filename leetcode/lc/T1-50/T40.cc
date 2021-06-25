

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
    {
        set<vector<int>> res;
        vector<int> tmp;
        dfs(0, 0, target, res, candidates, tmp);  

        return vector<vector<int>> (res.begin (), res.end ());


        
    }
    void dfs(int now, int score, int target,set<vector<int>> &res, vector<int> &candidates, vector<int> v)
    {
        if (score == target)
        {
            vector<int> x = v;
            sort(x.begin (), x.end());
            res.insert(x);
            return;
        }
        if (now == candidates.size())
            return;
        dfs(now + 1, score, target, res, candidates, v);
        v.push_back(candidates[now]);
        dfs(now + 1, score + candidates[now], target, res, candidates,v);
    }
};

int main()
{ 

    vector<int> v{10, 1, 2, 7, 6, 1, 5};
    Solution s;
    auto it = s.combinationSum2(v, 8);
    for (auto i : it)
    {
        for (auto j : i)
        {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}



// [[7,1],[2,1,5],[2,6],[1,6,1],[1,7],[1,2,5]]
// [[1,1,6],[1,2,5],[1,7],[2,6]]