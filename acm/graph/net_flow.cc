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

#define MAX 409
#define INF 2000000000
using namespace std;

struct Edge
{
    int to;
    int next;
    int cap;
} edge[MAX * MAX * MAX * 2];

int head[MAX], c, level[MAX];

void add_edge(int u, int v, int cap)
{
    edge[c].to = v;
    edge[c].next = head[u];
    edge[c].cap = cap;
    head[u] = c;
    c++;

    edge[c].to = u;
    edge[c].next = head[v];
    edge[c].cap = 0;
    head[v] = c;
    c++;
}

int bfs(int s)
{
    int u, v, i;
    queue<int> qi;
    memset(level, -1, sizeof(level));
    qi.push(s);
    level[s] = 0;
    while (!qi.empty())
    {
        u = qi.front();
        qi.pop();
        for (i = head[u]; i != -1; i = edge[i].next)
        {
            v = edge[i].to;
            if (edge[i].cap > 0 && level[v] == -1)
            {
                level[v] = level[u] + 1;
                qi.push(v);
            }
        }
    }
    return false;
}

int dfs(int s, int t, int f)
{
    int i, v, d, res;
    if (s == t)
        return f;
    res = 0;
    for (i = head[s]; i != -1; i = edge[i].next)
    {
        v = edge[i].to;
        if (level[s] + 1 == level[v] && edge[i].cap > 0)
        {
            d = dfs(v, t, min(edge[i].cap, f - res));
            if (d > 0)
            {
                edge[i].cap -= d;
                edge[i ^ 1].cap += d;
                res += d;
                if (res == f)
                    return res;
            }
        }
    }
    return res;
}

int dinic(int s, int t)
{
    int f, flow;
    flow = 0;
    while (1)
    {
        bfs(s);
        if (level[t] == -1)
            break;
        f = dfs(s, t, INF);
        flow += f;
    }
    return flow;
}
void init()
{
    int n, m, s, t;
    cin >> n >> m >> s >> t;
    c = 0;
    memset(head, -1, sizeof(head));
    for (int i = 1; i <= m; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        add_edge(u, v, w);
    }
    cout << dinic(s, t) << endl;
}
int main(int argc, char *argv[])
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