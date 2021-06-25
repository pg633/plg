
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canTransform(string start, string end)
    {
        int l = 0;
        int r = 0;
        int len = start.size();
        while (l < len || r < len)
        {
            while (l < len && start[l] == 'X')
                ++l;
            while (r < len && end[r] == 'X')
                ++r;
     if((l < len) ^ (r < len)) return false;
         
            if (l > len && r > len)
                return true;
            if (start[l] != end[r] || (start[l] == 'L' && l < r) || (end[r] == 'R' && l > r))
                return false;
                ++l;++r;
        }
        return l == r;
    }
};