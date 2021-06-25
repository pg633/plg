#include <iostream>
#include <cmath>
using namespace std;

const int maxn = 1e6;
class st
{
private:
    int n, m;
    int a[maxn], maxnn[maxn][21];

private:
    void init()
    {
        for (int i = 1; i <= n; i++)
            maxnn[i][0] = a[i];
        for (int j = 1; j <= 21; j++)
        {
            for (int i = 1; i + (1 << j) - 1 <= n; i++)
            {
                maxnn[i][j] = max(maxnn[i][j - 1], maxnn[i + (1 << (j - 1))][j - 1]);
            }
        }
    }
    int query(int l, int r)
    {
        int k = log2(r - l + 1);
        return max(maxnn[l][k], maxnn[r - (1 << k) + 1][k]);
    }

public:
    st()
    {

        cin >> n >> m;
        for (int i = 1; i <= n; i++)
            cin >> a[i];

        init();
        int x, y;

        for (int i = 1; i <= m; i++)
        {
            cin >> x >> y;
            cout << query(x, y) << endl;
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
    // st *s = new st();


    return 0;
}
