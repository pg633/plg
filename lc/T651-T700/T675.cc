class Solution
{
public:
    int cutOffTree(vector<vector<int>> &forest)
    {
        if (forest.size() == 0)
            return 0;
        if (forest[0].size() == 0)
            return 0;
        int n = forest.size(), m = forest[0].size();
        map<int, vector<int>> ma;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (forest[i][j] == 0)
                    continue;
                else
                {
                    ma[forest[i][j]] = {i, j};
                }

        int x = 0, y = 0, res = 0;
        for (auto it : ma)
        {
            int i = it.second[0], j = it.second[1];
            int ans = astar(forest, x, y, i, j);
            if (ans == -1)
            {
                return -1;
            }

            res += ans;
            forest[i][j] = 1;
            x = i, y = j;
        }
        return res;
    }
    int can_touch(vector<vector<int>> &forest, int x, int y, int i, int j)
    {
        int n = forest.size(), m = forest[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        queue<pair<int, int>> q;
        q.push({x, y});
        int level = 0;
        while (!q.empty())
        {
            int t = q.size();
            while (t--)
            {
                auto p = q.front();
                q.pop();
                ;
                if (p.first == i && p.second == j)
                    return level;
                if (vis[p.first][p.second] || forest[p.first][p.second] == 0)
                    continue;
                vis[p.first][p.second] = true;
                if (p.first > 0)
                    q.push({p.first - 1, p.second});
                if (p.first < n - 1)
                    q.push({p.first + 1, p.second});
                if (p.second > 0)
                    q.push({p.first, p.second - 1});
                if (p.second < m - 1)
                    q.push({p.first, p.second + 1});
            }
            level++;
        }
        return -1;
    }
   
    struct mycompare
    {
        int a;
        int b;
        int c;
        int d;
        bool operator()(mycompare &a, mycompare &b)
        {
            return a.a > b.a;
        }
    };

    int astar(vector<vector<int>> &forest, int x, int y, int i, int j)
    {
        int n = forest.size(), m = forest[0].size();

        priority_queue<mycompare, vector<mycompare>, mycompare> q;

        q.push({0, 0, x, y});
        vector<vector<int>> cost(n, vector<int>(m, 0));
        cost[x][y] = 0;
        int dir[][2] = {{0, 1}, {0,-1},{1,0},{-1,0}};
        while (!q.empty())
        {
            auto &c = q.top();
            q.pop();
            int f = c.a, g = c.b, r = c.c, t = c.d;
            if (r == i && t == j)
                return g;
            for (int i = 0; i < 4; i++)
            {
                int nr = r + dir[i][0];
                int nt = t + dir[i][1];
                if (nr >= 0 && nr < n && nt >= 0 && nt < m && forest[nr][nt] != 0)
                {
                    int ncost = g + 1 + abs(nr - i) + abs(nt - j);
                    if (cost[nr][nt] == 0 || cost[nr][nt] > ncost)
                    {
                        cost[nr][nt] = ncost;
                        q.push({ncost, g + 1, nr, nt});
                    }
                }
            }
        }
        return -1;
    }
};
