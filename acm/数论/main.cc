#include<bits/stdc++.h>
#define ll long long
#define MAXN 10000005
using namespace std;
int a[MAXN],pos[MAXN];
 
int gcd(int a,int b)
{
    return b==0?a:gcd(b,a%b);
}
 
int main()
{
    int n,x,aa=0,bb=0,maxn=0;
    ll maxs=99999999999999;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        scanf("%d",&x);
        a[x]++;
        if(a[x]>1&&x<maxs)//特殊判断
        {
            maxs=x;
            aa=pos[x];
            bb=i;
        }
        else pos[x]=i;
        maxn=max(maxn,x);
    }
    int cas;
    for(int i=1;i<=maxn;i++)
    {
        cas=0;
        for(int j=i;j<=maxn;j+=i)
        {
            if(a[j]==0)
                continue;
            if(cas==0)
                cas=j;
            else{
                ll t=gcd(cas,j);
                ll lcm=cas*(j/t);
                if(lcm<maxs)
                {
                    maxs=lcm;
                    aa=pos[cas];
                    bb=pos[j];
                }
                break;
            }
        }
    }
    if(aa>bb)
        swap(aa,bb);
    printf("%d %d\n",aa,bb);
    return 0;
}