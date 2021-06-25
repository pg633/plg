#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <cstdlib>
#include <map>
#include <queue>
#include <cstdio>
#include <cstring>
#include <cmath>
#include <vector>
using namespace std;
// const int maxn = 1e5 * 2 + 5;
// const int minn = 1000;
// class graph
// {
// private:
//     int n, m;
//     int color[maxn];
//     vector<int> nxt[maxn];
//     bool dfs(int u, int c)
//     {
//         color[u] = c;
//         for (int i = 0; i < nxt[u].size(); i++)
//         {
//             if (color[nxt[u][i]] == c)
//                 return false;
//             if (color[nxt[u][i]] == 0 && !dfs(nxt[u][i], -c))
//                 return false;
//         }
//         return true;
//     }
// public:
//     graph()
//     {
//         int n, m;
//         cin >> n >> m;
//         for (int i = 1; i <= m; i++)
//         {
//             int x, y;
//             cin >> x >> y;
//             nxt[x].push_back(y);
//             nxt[y].push_back(x);
//         }
//         for (int i = 1; i <= n; i++)
//         {
//             if (color[i] == 0)
//             {
//                 if (!dfs(i, 1))
//                 {
//                     cout << "No" << endl;
//                     return;
//                 }
//             }
//         }
//         cout << "Yes" << endl;
//     }
// };
// class hungary
// {
// private:
//     int vis[maxn], match[maxn];
//     vector<int> nxt[maxn];
//     bool dfs(int u, int tag)
//     {
//         if (vis[u] == tag)
//             return false;
//         vis[u] = tag;
//         for (auto v : nxt[u])
//             if (match[v] == 0 || dfs(match[v], tag))
//             {
//                 match[v] = u;
//                 return true;
//             }
//         return false;
//     }
// public:
//     hungary()
//     {
//         int n, m, e;
//         cin >> n >> m >> e;
//         for (int i = 0; i < e; i++)
//         {
//             int u, v;
//             cin >> u >> v;
//             nxt[u].push_back(v);
//         }
//         int ans = 0;
//         for (int i = 1; i <= n; i++)
//             if (dfs(i, i))
//                 ++ans;
//         cout << ans << endl;
//     }
// };
// class hungary2
// {
// private:
//     int g[minn][minn];
//     int vis[maxn], match[maxn];
//     int n, m;
// private:
//     int dfs(int u)
//     {
//         for (int i = 1; i <= n; i++)
//         {
//             if (g[u][i] && vis[i] == 0)
//             {
//                 vis[i] = 1;
//                 if (match[i] == 0 || dfs(match[i]))
//                 {
//                     match[i] = u;
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// public:
//     hungary2()
//     {
//         cin >> n >> m;
//         while (m--)
//         {
//             int c, r;
//             scanf("%d%d", &c, &r);
//             g[c][r] = 1;
//         }
//         int ans = 0;
//         for (int i = 1; i <= n; i++)
//         {
//             memset(vis, 0, sizeof(vis));
//             if (dfs(i))
//                 ans++;
//         }
//         printf("%d\n", ans);
//     }
// };
// class hungary
// {
// private:
//     int n, m, e;
//     int vis[maxn], match[maxn];
//     vector<int> nxt[maxn];
// private:
//     bool dfs(int u)
//     {
//         for (auto v : nxt[u])
//         {
//             if (vis[v] == 0)
//             {
//                 vis[v] = 1;
//                 if (match[v] == 0 || dfs(match[v]))
//                 {
//                     match[v] = u;
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// public:
//     hungary()
//     {
//         cin >> n >> m >> e;
//         int u, v;
//         for (int i = 0; i < e; i++)
//         {
//             cin >> u >> v;
//             nxt[u].push_back(v);
//         }
//         int ans = 0;
//         for (int i = 1; i <= n; i++)
//         {
//             memset(vis, 0, sizeof(vis));
//             if (dfs(i))
//                 ++ans;
//         }
//         cout << ans << endl;
//     }
// };
// class subset
// {
// private:
//     int n, m, e;
//     int vis[maxn], match[maxn];
//     int g[minn][minn];
// private:
//     bool dfs(int u)
//     {
//         for (int i = 0; i <= n; i++)
//         {
//             int v = i;
//             if (g[u][i] && vis[v] == 0)
//             {
//                 vis[v] = 1;
//                 if (match[v] == 0 || dfs(match[v]))
//                 {
//                     match[v] = u;
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     int hung()
//     {
//         int tot = 0;
//         memset(match, 0, sizeof(match));
//         for (int i = 1; i <= n; i++)
//         {
//             memset(vis, 0, sizeof(vis));
//             if (dfs(i))
//                 tot++;
//         }
//         return tot;
//     }
// private:
//     struct hi
//     {
//         int h;
//         char sex;
//         char music[110], sport[110];
//     } x[minn];
//     bool ok(int i, int j)
//     {
//         if (abs(x[i].h - x[j].h) > 40)
//             return 1;
//         if (x[i].sex == x[j].sex)
//             return 1;
//         if (strcmp(x[i].music, x[j].music) != 0)
//             return 1;
//         if (strcmp(x[i].sport, x[j].sport) == 0)
//             return 1;
//         return 0;
//     }
// public:
//     subset()
//     {
//         int t;
//         scanf("%d", &t);
//         while (t--)
//         {
//             scanf("%d", &n);
//             memset(g, 0, sizeof(g));
//             for (int i = 1; i <= n; i++)
//             {
//                 scanf("%d %c%s%s", &x[i].h, &x[i].sex, x[i].music, x[i].sport);
//                 for (int j = 1; j < i; j++)
//                     if (!ok(i, j))
//                     {
//                         g[i][j] = g[j][i] = 1;
//                     }
//             }
//             cout << n - hung() / 2 << endl;
//         }
//     }
// };

/** 
 * 二分图
 */

// int g[minn][minn], vis[maxn], match[maxn];
// int n, m, t, u, v;
// bool dfs(int u)
// {
//     for (int i = 1; i <= n; i++)
//     {
//         if (g[u][i] && vis[i] == 0)
//         {
//             vis[i] = 1;
//             if (match[i] == -1 || dfs(match[i]))
//             {
//                 match[i] = u;
//                 return true;
//             }
//         }
//     }
//     return false;
// }
// int hugary()
// {
//     memset(match, -1, sizeof(match));
//     int ans = 0;
//     for (int i = 1; i <= n; i++)
//     {
//         memset(vis, 0, sizeof(vis));
//         if (dfs(i))
//             ++ans;
//     }
//     return n - ans;
// }
// void init()
// {
//     cin >> t;
//     while (t--)
//     {
//         memset(g, 0, sizeof(g));
//         cin >> n >> m;
//         for (int i = 0; i < m; i++)
//         {
//             cin >> u >> v;
//             g[u][v] = 1;
//         }
//         cout << hugary() << endl;
//     }
// }

/** 
 * km 求 完备匹配
 */
// int n, m;
// const int maxn = 1005;
// const int INF = (1 << 30) - 1;
// int g[maxn][maxn];
// int lx[maxn], ly[maxn];
// int match[maxn];
// bool visx[maxn], visy[maxn];
// int slack[maxn];
// bool dfs(int cur)
// {
//     visx[cur] = true;
//     for (int i = 1; i <= m; i++)
//     {
//         if (visy[i])
//             continue;
//         int t = lx[cur] + ly[i] - g[cur][i];
//         if (t == 0)
//         {
//             visy[i] = true;
//             if (match[i] == -1 || dfs(match[i]))
//             {
//                 match[i] = cur;
//                 return true;
//                 ;
//             }
//         }
//         else if (slack[i] > t)
//         {
//             slack[i] = t;
//         }
//     }
//     return false;
// }
// int km()
// {
//     memset(match, -1, sizeof(match));
//     memset(ly, 0, sizeof(ly));
//     for (int i = 1; i <= n; i++)
//     {
//         lx[i] = -INF;
//         for (int j = 1; j <= m; j++)
//         {
//             if (g[i][j] > lx[i])
//                 lx[i] = g[i][j];
//         }
//     }
//     for (int x = 1; x <= n; x++)
//     {
//         for (int i = 1; i <= m; i++)
//         {
//             slack[i] = INF;
//         }
//         while (true)
//         {
//             memset(visx, false, sizeof(visx));
//             memset(visy, false, sizeof(visy));
//             if (dfs(x))
//                 break;
//             int d = INF;
//             for (int i = 1; i <= m; i++)
//             {
//                 if (!visy[i] && d > slack[i])
//                     d = slack[i];
//             }
//             for (int i = 1; i <= n; i++)
//             {
//                 if (visx[i])
//                     lx[i] -= d;
//             }
//             for (int i = 1; i <= m; i++)
//             {
//                 if (visy[i])
//                     ly[i] += d;
//                 else
//                     slack[i] -= d;
//             }
//         }
//     }
//     int ans = 0;
//     for (int i = 1; i <= m; i++)
//     {
//         if (match[i] > -1)
//         {
//             ans += g[match[i]][i];
//         }
//     }
//     return ans;
// }
// void init()
// {
//     while (cin >> n >> m)
//     {
//         memset(g,0,sizeof(g));
//         for (int i = 1; i <= n; i++)
//             for (int j = 1; j <= m; j++)
//             {
//                 cin >> g[i][j];
//                 g[i][j] *= 100;
//             }
//         int pre_sum = 0;
//         for (int i = 1; i <= n; i++)
//         {
//             int t;
//             cin >> t;
//             pre_sum += g[i][t];
//             g[i][t]++;
//         }
//         int sum = km();
//         cout <<( n - sum % 100) << " " << sum / 100 - pre_sum / 100 << endl;
//     }
// }


int main()
{

#ifdef ONLINE_JUDGE
    std::ios::sync_with_stdio(false);
#else
    freopen("in", "r", stdin);
    freopen("out", "w", stdout);
#endif
    init();

    return 0;
}
