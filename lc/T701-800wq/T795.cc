class Solution
{
public:
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {
        int v = grid.size();
        int w = grid[0].size();
        int cnt = 0;
        for (int i = 0; i < v; i++)
            for (int j = 0; j < w; j++)
            {
                if (grid[i][j] == 1)
                {
                    cnt = max(cnt, dfs(grid, i, j, v, w));
                }
            }
        return cnt;
    }
    int dfs(vector<vector<int>> &grid, int i, int j, int v, int w)
    {
        if (i >= 0 && i < v && j >= 0 && j < w && grid[i][j] == 1)
        {
         
            grid[i][j] = 0; 
            return 1 + dfs(grid, i + 1, j, v, w) +
                   dfs(grid, i - 1, j, v, w) +
                   dfs(grid, i, j + 1, v, w) +
                   dfs(grid, i, j - 1, v, w);
        }
        return 0;
    }
    };