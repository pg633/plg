#include <iostream>
#include <algorithm>
#include <cstring>
#include <ctime>
using namespace std;
/**
 * 获取素数
 */
namespace sushu
{
    const int maxn = 1e8 + 10;
    int num = 0;
    int vis[maxn], pri[maxn];
    int N;

    void getpri()
    {
        for (int i = 2; i <= N; i++)
        {
            if (!vis[i])
                pri[++num] = i;
            for (int j = 1; j <= num && pri[j] * i < N; j++)
            {
                vis[pri[j] * i] = 1;
                if (i % pri[j] == 0)
                    break;
            }
        }
    }
    void init()
    {
        int t;
        cin >> N >> t;
        getpri();
        while (t--)
        {
            int k = 0;
            cin >> k;
            cout << pri[k] << endl;
        }
    }
};  // namespace sushu
    // namespace sushu

/**
 * milller_rabin 算法
 * 费马小定理 
 * 二次探测原理
 */
namespace mr
{

    typedef long long ll;
    const int times = 10;
    class Miller_Rabin
    {
    private:
    private:
        ll fast_mod(ll a, ll b, ll mod) //计算2^q的过程
        {
            ll res = 0;
            while (b)
            {
                if (b & 1)
                    res = res + a;
                a <<= 1;
                if (a >= mod)
                    a -= mod;
                if (res >= mod)
                    res -= mod;
                b >>= 1;
            }
            return res;
        }
        ll fast_pow_mod(ll a, ll b, ll mod) //快速幂算出a^m
        {
            ll res = 1;
            while (b)
            {
                if (b & 1)
                    res = (res * a) % mod;
                a = (a * a) % mod;
                b >>= 1;
            }
            return res;
        }
        bool check(ll a, ll m, ll p, ll n) //对于每次随机的a进行测试
        {
            ll temp = fast_pow_mod(a, m, n), ret = temp;
            for (int i = 0; i < p; ++i)
            {
                ret = fast_mod(temp, temp, n);
                if (ret == 1 && temp != n - 1 && temp != 1)
                    return true;
                temp = ret;
            }
            return ret != 1;
        }

    public:
        bool is_prime(ll n)
        {
            if (n < 2)
                return false;
            if (n == 2)
                return true;
            if (n & 1 == 0)
                return false;
            // 2^p = n-1
            ll p = 0, x = n - 1;
            while (x & 1 == 0)
            {
                x <<= 1;
                p++;
            }
            for (int i = 0; i < times; i++)
            {
                ll a = rand() % (n - 1) + 1;
                if (check(a, x, p, n))
                    return false;
            }
            return true;
        }
    };
}; // namespace mr

/**
 * pollard-rho 算法
 */
typedef long long ll;

const int MAXN = 100;
const int S = 20;
ll T, N;
ll tol;
ll fact[MAXN];

ll mult_mod(ll a, ll b, ll c)
{
    a %= c;
    b %= c;
    ll ret = 0;
    while (b)
    {
        if (b & 1)
        {
            ret += a;
            ret %= c;
        }
        a <<= 1;
        if (a >= c)
            a %= c;
        b >>= 1;
    }
    return ret;
}
ll quick_pow(ll x, ll n, ll mod)
{
    if (n == 1)
        return x % mod;
    x %= mod;
    ll tmp = x;
    ll ret = 1;
    while (n)
    {
        if (n & 1)
            ret = mult_mod(ret, tmp, mod);
        tmp = mult_mod(tmp, tmp, mod);
        n >>= 1;
    }
    return ret;
}
bool check(ll a, ll n, ll x, ll t)
{
    ll ret = quick_pow(a, x, n);
    ll last = ret;
    for (int i = 1; i <= t; i++)
    {
        ret = mult_mod(ret, ret, n);
        if (ret == 1 && last != 1 && last != n - 1)
            return true;
        last = ret;
    }
    if (ret != 1)
        return true;
    return false;
}
bool Miller_Rabin(ll n)
{
    if (n < 2)
        return false;
    if (n == 2)
        return true;
    if ((n & 1) == 0)
        return false;
    ll x = n - 1;
    ll t = 0;
    while ((x & 1) == 0)
    {
        x >>= 1;
        t++;
    }
    for (int i = 0; i < S; i++)
    {
        ll a = rand() % (n - 1) + 1;
        if (check(a, n, x, t))
            return false;
    }
    return true;
}
ll gcd(ll a, ll b)
{
    if (a == 0)
        return 1;
    if (a < 0)
        return gcd(-a, b);
    while (b)
    {
        ll t = a % b;
        a = b;
        b = t;
    }
    return a;
}
ll Pollard_rho(ll x, ll c)
{
    ll i = 1, k = 2;
    ll x0 = rand() % x;
    ll y = x0;
    while (1)
    {
        i++;
        x0 = (mult_mod(x0, x0, x) + c) % x;
        ll d = gcd(y - x0, x);
        if (d != 1 && d != x)
            return d;
        if (y == x0)
            return x;
        if (i == k)
        {
            y = x0;
            k += k;
        }
    }
}
void findfac(ll n)
{
    if (Miller_Rabin(n))
    {
        fact[tol++] = n;
        return;
    }
    ll p = n;
    while (p >= n)
        p = Pollard_rho(p, rand() % (n - 1) + 1);
    findfac(p);
    findfac(n / p);
}

int main()
{

#ifndef ONLINE_JUDGE
    freopen("in", "r", stdin);
    freopen("out", "w", stdout);
#endif
    std::ios::sync_with_stdio(false);

    ll ans;
    cin>>T;
    while(T--)
    {
        cin>>N;
        if(N==1 || (Miller_Rabin(N))){
            cout<<"Prime"<<endl;
            continue;
        }
        tol = 0;
        findfac(N);
        cout<<*min_element(fact,fact+tol)<<endl;
    }
    
}