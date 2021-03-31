#include <iostream>
#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

#define ls(x) x << 1
#define rs(x) x << 1 | 1

typedef unsigned long long ull;
typedef unsigned long long ll;

const int MAXN = 1000003;
const int inf = 1e7;
const int maxn = 1000003;

class segment_tree
{
private:
    ull n, m;
    ull a[maxn], add[maxn << 2], lazy[maxn << 2];

private:
    void build(int x, int l, int r)
    {
        lazy[x] = 0;
        if (l == r)
        {
            add[x] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(ls(x), l, mid);
        build(rs(x), mid + 1, r);
        push_up(x);
    }
    void push_up(int x)
    {
        add[x] = add[ls(x)] + add[rs(x)];
    }
    void fi(int p, int l, int r, int n)
    {
        lazy[p] = lazy[p] + n;
        add[p] = add[p] + n * (r - l + 1);
    }
    void push_down(int x, int l, int r)
    {
        ll mid = (l + r) >> 1;
        fi(ls(x), l, mid, lazy[x]);
        fi(rs(x), mid + 1, r, lazy[x]);
        lazy[x] = 0;
    }

public:
    segment_tree()
    {
        cin >> n >> m;
        for (int i = 1; i <= n; i++)
        {
            cin >> a[i];
        }
        build(1, 1, n);
    }

    void update(ll nl, ll nr, ll l, ll r, ll p, ll k)
    {
        if (nl <= l && nr >= r)
        {
            add[p] += k * (r - l + 1);
            lazy[p] += k;
            return;
        }
        push_down(p, l, r);
        int mid = (l + r) >> 1;
        if (nl <= mid)
            update(nl, nr, l, mid, ls(p), k);
        if (nr > mid)
            update(nl, nr, mid + 1, r, rs(p), k);
        push_up(p);
    }

    // void update2(ll nl,ll nr,ll l,ll r,ll p,ll k)
    // {
    //     if(nl<=l&&r<=nr)
    //     {
    //         add[p]+=k*(r-l+1);
    //         lazy[p]+=k;
    //         return ;
    //     }
    //     push_down(p,l,r);
    //     ll mid=(l+r)>>1;
    //     if(nl<=mid)update(nl,nr,l,mid,ls(p),k);
    //     if(nr>mid) update(nl,nr,mid+1,r,rs(p),k);
    //     push_up(p);
    // }

    ll query(ll qx, ll qy, ll l, ll r, ll p)
    {
        if (qx <= l && qy >= r)
        {
            return add[p];
        }
        ll res = 0;
        ll mid = (l + r) >> 1;
        push_down(p, l, r);
        if (qx <= mid)
            res += query(qx, qy, l, mid, ls(p));
        if (qy > mid)
            res += query(qx, qy, mid + 1, r, rs(p));
        return res;
    }

public:
    void run_query()
    {
        ll b, c, d, e, f;
        for (int i = 0; i < m; i++)
        {
            cin >> b;
            switch (b)
            {
            case 1:
            {
                cin >> c >> d >> e;
                update(c, d, 1, n, 1, e);
                break;
            }
            case 2:
            {
                cin >> c >> d;
                cout << query(c, d, 1, n, 1) << endl;
                break;
            }
            }
        }
    }
};

class modui
{

private:
    int n, size, bnum, m, now;
    int belong[maxn], cnt[maxn], aa[maxn], ans[maxn];
    struct query
    {
        int l, r, id;
    } q[maxn];

public:
    modui()
    {
        cin >> n;
        for (int i = 1; i <= n; i++)
            cin >> aa[i];
        size = sqrt(n);
        bnum = ceil(double(n) / size);
        for (int i = 1; i <= bnum; i++)
            for (int j = (i - 1) * size + 1; j <= i * size; j++)
                belong[j] = i;
        cin >> m;
        for (int i = 1; i <= m; i++)
        {
            cin >> q[i].l >> q[i].r;
            q[i].id = i;
        }
        sort(q + 1, q + m + 1, [&](auto &a, auto &b) {
            return (belong[a.l] ^ belong[b.l]) ? belong[a.l] < belong[b.l] : ((belong[a.l] & 1) ? a.r < b.r : a.r > b.r);
        });
        int l = 1, r = 0;
        for (int i = 1; i <= m; i++)
        {
            int ql = q[i].l, qr = q[i].r;
            while (l < ql)
                now -= !--cnt[aa[l++]];
            while (l > ql)
                now += !cnt[aa[--l]]++;
            while (r < qr)
                now += !cnt[aa[++r]]++;
            while (r > qr)
                now -= !--cnt[aa[r--]];

            ans[q[i].id] = now;
        }
        for (int i = 1; i <= m; i++)
            cout << ans[i] << endl;
    }
};

class modui_r
{
private:
    int n, m, now, size, bnum;
    int belong[maxn], cnt[maxn], aa[maxn], ans[maxn];
    struct query
    {
        int l, r, q, t;
    } q[maxn];
    int cntq, cntc;

    struct modify
    {
        int pos, color, last;

    } cm[maxn];

public:
    modui_r()
    {
        cin >> n;
        for (int i = 1; i <= n; i++)
            cin >> aa[i];

        size = sqrt(n);
        bnum = ceil(double(n) / size);
        for (int i = 1; i <= bnum; i++)
            for (int j = (i - 1) * size + 1; j <= i * size; j++)
                belong[j] = i;

        cin >> m;
        for (int i = 1; i <= m; i++)
        {
            char c;
            cin >> c;
            switch (c)
            {
            case 'Q':
            {
                cin >> q[++cntq].l >> q[cntq].r;
                q[cntq].t = cntc;
                q[cntq].q = cntq;
                break;
            }
            case 'R':
            {
                cin >> cm[++cntc].pos >> cm[cntc].color;
                break;
            }
            }
        }

        sort(q + 1, q + cntq + 1, [&](auto &l, auto &r) {
            return (belong[l].l ^ belong[r].l) ? belong[l].l < belong[r].l
                                               : ((belong[l].r ^ belong[r].r) ? belong[l].r < belong[r].r : l.t < r.t);
        });

        int l = 1, r = 0, time = 0, now = 0;
        for (int i = 1; i <= cntq; ++i)
        {
            int ql = q[i].l, qr = q[i].r, qt = q[i].t;

            while (l < ql)
                now -= !--cnt[aa[l++]];
            while (l > ql)
                now += !cnt[aa[--l]]++;
            while (r < qr)
                now += !cnt[aa[++r]]++;
            while (r > ql)
                now -= !--cnt[aa[r--]];

            while (time < qt)
            {
                ++time;
                if(ql<=cm[time].pos && qr>=cm[time].pos ) 
                now -= !--cnt[aa[cm[time].pos]] -!cnt[cm[time].color]++;
                swap(aa[cm[time].pos], cm[time].color);
            }
            while (time > qt)
            {
                
                if(ql<=cm[time].pos && qr>=cm[time].pos ) 
                now -= !--cnt[aa[cm[time].pos]] -!cnt[cm[time].color]++;
                swap(aa[cm[time].pos], cm[time].color);
                --time;
            }
            ans[q[i].q] = now;
        }
        for (int i = 1; i <= cntq; i++)
        {
            cout << ans[i] << endl;
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
    // segment_tree *s = new segment_tree();
    // s->run_query();
    // modui *s = new modui();

    return 0;
}
