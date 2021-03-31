#include <bits/stdc++.h>
using namespace std;

class uf
{
private:
    static const int maxnn = 1e6;
    int fa[maxnn];

private:
    int getf(int x)
    {
        while (fa[x] != x)
        {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return fa[x];
    }
    void union_f(int x, int y)
    {
        int fx = getf(x);
        int fy = getf(y);
        if (fx != fy)
            fa[fx] = fy;
    }
    bool is_union(int x, int y)
    {
        return getf(x) == getf(y);
    }

public:
    uf()
    {
        int n, m;
        cin >> n >> m;
        for (int i = 1; i <= n; i++)
            fa[i] = i;
        int x, y, z;
        for (int i = 1; i <= m; i++)
        {
            cin >> x >> y >> z;
            switch (x)
            {
            case 1:
            {
                union_f(y, z);
                break;
            }
            case 2:
            {
                cout << (is_union(y, z) ? "Y" : "N") << endl;
                break;
            }
            }
        }
    }
};
int main()
{

#ifdef ONLINE_JUDGE
    std::ios::sync_with_stdio(false);
#else
    freopen("in", "r", stdin);
    freopen("out", "w", stdout);
#endif
    uf *s = new uf();

    return 0;
}