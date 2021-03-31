#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<string> letterCasePermutation(string S)
    {
        vector<string> res;
        dfs(S, 0, S.length(), S, res);
        return res;
    }
    void dfs(string S, int now, int len, string _S, vector<string> &res)
    {
        if (now == len)
        {
            res.emplace_back(_S);
            return;
        }
        dfs(S, now + 1, len, _S, res);
        if (isalpha(_S[now]))
        {
            _S[now] ^= (1 << 5);
            dfs(S, now + 1, len, _S, res);
        }
    }
};