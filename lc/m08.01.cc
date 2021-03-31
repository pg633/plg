#include <bits/stdc++.h>
using namespace std; //

class Solution
{
public:
    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int newColor)
    {
        vector<vector<bool>> vis(image.size(), vector<bool>(image[0].size(), false));
        cout<<1 <<endl;
        dfs(image, vis, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    void dfs(vector<vector<int>> &image, vector<vector<bool>> &vis, int i, int j, int newColor, int old)
    {
         cout<< i << " " <<j <<endl;
        if (i >= 0 && i < image.size() && j >= 0 && j < image[0].size() && !vis[i][j] && image[i][j] == old)
        {
        cout<<2 <<endl;
            vis[i][j] = true;
            image[i][j] = newColor;
            dfs(image, vis, i + 1, j, newColor, old);
            dfs(image, vis, i, j - 1, newColor, old);
            dfs(image, vis, i - 1, j, newColor, old);
            dfs(image, vis, i, j + 1, newColor, old);
        }
    }
};

// class Solution {
// public:
//     vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
//         if(newColor == image[sr][sc])   return image;
//         else dfs(image, sr, sc, newColor, image[sr][sc]);
//         return image;
//     }
//     void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int c){
//         if(sr < 0 || sr >= image.size() || sc < 0 || sc >= image[0].size()) return;
//         if(image[sr][sc] == c){
//             image[sr][sc] = newColor;
//             dfs(image, sr + 1, sc, newColor, c);
//             dfs(image, sr - 1, sc, newColor, c);
//             dfs(image, sr, sc - 1, newColor, c);
//             dfs(image, sr, sc + 1, newColor, c);
//         }
//     }
// };
int main()
{

    vector<vector<int>> image{
        {1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

    Solution s;
    s.floodFill(image, 1, 1, 2);
}