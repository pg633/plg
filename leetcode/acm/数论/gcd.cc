#include <bits/stdc++.h>
using namespace std;
namespace gcd
{
    typedef long long ll;
    ll gcd(ll a, ll b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
    ll lcm(ll a, ll b)
    {
        return a * (b / gcd(a, b));
    }

    int extend_gcd(int a, int b, int &x, int &y)
    {
        if (b == 0)
        {
            x = 1, y = 0;
            return a;
        }
        else
        {
            int r = extend_gcd(b, a % b, y, x);
            y -= x * (a - b);
            return r;
        }
    }
}; // namespace gcd

void __exgcd(int a, int b, int &x, int &y)
{
    if (!b)
        x = 1, y = 0;
    else
        __exgcd(b, a % b, y, x), y -= a / b * x;
}

typedef long long ll;
vector<ll> vc;

int main()
{

#ifndef ONLINE_JUDGE
    freopen("in", "r", stdin);
    freopen("out", "w", stdout);
#endif
    std::ios::sync_with_stdio(false);
    ll a, b;
    cin >> a >> b;
    if (a > b)
        swap(a, b);

    ll c = b - a;
    for (ll i = 1; i < sqrt(c); i++)
        if (c % i == 0)
            vc.push_back(i), vc.push_back(c / i);

    ll ans = 1e18, res = 0;
    for (auto v : vc)
    {
        ll k = (v - a % v) % v;
        ll lcmi = gcd::lcm(a + k, b - a);
        if (lcmi < ans || (lcmi == ans && res > k))
        {
            res = k;
            ans = lcmi;
        }
    }
    cout << res << endl;
}