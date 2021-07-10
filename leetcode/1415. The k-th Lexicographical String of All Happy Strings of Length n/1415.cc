

#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    string getHappyString(int n, int k)
    {
        string s = "";
        int id = 0;
        dfs(-1, 0, n, k, id, s);
        return s;
    }
    bool dfs(int index, int now, int n, int k, int id, string &s)
    {
        if (now == n)
        {
            id++;
            return id == k;
        }
        for (int i = 0; i < 3; i++)
        {
            if (i == index)
                continue;
            s = s + (char)((int)'a'+ i);
            if(dfs(i,now+1,n,k,id,s)) return true;
            s = s.substr(0,s.length()-1);
        }
        return false;
    }
};

int main()
{

    return 0;
}

// [[7,1],[2,1,5],[2,6],[1,6,1],[1,7],[1,2,5]]
// [[1,1,6],[1,2,5],[1,7],[2,6]]