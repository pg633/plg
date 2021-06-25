#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> PII;
typedef pair<int, pair<int, int>> PIII;

const int N = 1010, M = 200010;
int n, m, S, T, K;
int h[N], rh[N], e[M], w[M], ne[M], idx;
int dist[N], f[N], cnt[N];
bool st[N];
void add(int *h, int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
    return;
}
void dijstra()
{
    priority_queue<PII, vector<PII>, greater<PII>> heap;
    heap.push({0, T});

    memset(dist, 0x3f, sizeof dist);

    dist[T] = 0;

    while (heap.size())
    {
        auto t = heap.top();
        heap.pop();

        int ver = t.second;
        if (st[ver])
            continue;
        st[ver] = true;

        for (int i = rh[ver]; ~i; i = ne[i])
        {
            int j = e[i];
            if (dist[j] > dist[ver] + w[i])
            {
                dist[j] = dist[ver] + w[i];
                heap.push({dist[j], j});
            }
        }
    }
    memcpy(f, dist, sizeof dist);
}
int a_star()
{

    priority_queue<PIII, vector<PIII>, greater<PIII>> heap;
    heap.push({f[S], {0, S}});
    while (heap.size())
    {
        auto t = heap.top();
        heap.pop();
        int ver = t.second.second;
        int dis = t.second.first;

        cnt[ver]++;
        // 判断结束的时候的数据是 T
        if (cnt[T] == K)
            return dis;

        for (int i = h[ver]; ~i; i = ne[i])
        {
            int j = e[i];
            if (cnt[j] < K)
            {
                heap.push(
                    {dis + w[i] + f[j], {dis + w[i], j}});
            }
        }
    }
    return -1;
}

int main()
{
#ifndef ONLINE_JUDGE
    freopen("in", "r", stdin);
#endif
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    memset(rh, -1, sizeof rh);
    while (m--)
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(h, a, b, c);
        add(rh, b, a, c);
    }
    scanf("%d%d%d", &S, &T, &K);
    if (S == T)
        K++;
    dijstra();

    cout << a_star() << endl;

    return 0;
}
// g++ a.cc -std=c++11 -o app && ./app