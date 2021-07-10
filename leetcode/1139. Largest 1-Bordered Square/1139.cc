#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int largest1BorderedSquare(vector<vector<int>> grid)
    {
        int r = grid.size();
        int c = grid[0].size();

        vector<vector<int>> l(r, vector<int>(c, 0)), u(r, vector<int>(c, 0));
        int mn = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
            {
                if (grid[i][j] == 0)
                    continue;
                l[i][j] = 1;
                u[i][j] = 1;

                if (j > 0)
                    l[i][j] += l[i][j - 1];
                if (i > 0)
                    u[i][j] += u[i - 1][j];

                auto p = min(l[i][j], u[i][j]);
                for (int k = p; k >= 0; k--)
                {
                    // cout << " " << k << " " << mn << " " << l[i - k + 1][j] << " " << u[i][j - k + 1] <<endl;
                    if (k > mn && l[i - k + 1][j] >= k && u[i][j - k + 1] >= k)
                    {
                        mn = k;
                    }
                }
            }
        return mn * mn;
    }
};

int main()
{
    Solution s;
    auto k = s.largest1BorderedSquare({{1, 1, 1}, {1, 0, 1}, {1, 1, 1}

    });
    cout << k << endl;
}
