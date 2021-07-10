#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int slidingPuzzle(vector<vector<int>> &board)
    {

        int from = board[0][0] * 100000 + board[0][1] * 10000 + board[0][2] * 1000 +
                     board[1][0] * 100 + board[1][1] * 10 + board[1][2];
        int end = 123405;

        vector<vector<int>> path {{0, 1}, {1, 2}, {3, 4}, {4, 5}, {0, 3}, {1, 4}, {2, 5}};
        set<int> s;
        queue<int> ({from});
        int res = 0;
        while (!q.empty())
        {
            int len = q.size();
            for (int i = 0; i < len; i++)
            {
                int front_num = q.front();
                q.pop();
                if (front_num == 123450)
                    return res;
                else if (front_num == 132450)
                    return -1;
                if(s.count(front_num)) {
                    continue;
                }
                for (auto it : path)
                {

                    {
                        string num = to_string(front_num);
                        if (num.length() == 5)
                            num = "0" + num;
                        if (num[it[0]] == '0' || num[it[1]] == '0')
                        {
                            swap(num[it[0]], num[it[1]]);
                            q.push(
                                atoi(num.c_str()));
                        }
                    }
                }
                s.insert(front_num);
            }
            res++;
        }
        return res;
    }
}; 