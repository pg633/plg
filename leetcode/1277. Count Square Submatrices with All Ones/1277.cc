class Solution
{
public:
    int countSquares(vector<vector<int>> &matrix)
    {
        int r = matrix.size();
        int c = matrix[0].size();

        vector<vector<int>> n(r, vector<int>(c, 0));
        int mx = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
            {
                if (i == 0 || j == 0)
                    n[i][j] = matrix[i][j];
                else if (matrix[i][j] == 0)
                    n[i][j] = 0;
                else
                    n[i][j] = min(min(n[i - 1][j], n[i][j - 1]), n[i - 1][j - 1]) + 1;
                mx += n[i][j];
            }
        return mx;
    }
};