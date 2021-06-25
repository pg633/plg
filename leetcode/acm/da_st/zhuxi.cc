#include <iostream>
#include <vector>
#include <algorithm>
#define nowp SegT[id]
#define lson SegT[id].lef
#define rson SegT[id].rig
#define MAXN 100000
using namespace std;

vector<int> v;

int getid(int x)
{
    return lower_bound(v.begin(), v.end(), x) - v.begin() + 1;
}

struct SegTree
{
    int lef;
    int rig;
    int val; //子树的数字个数
};

int num[MAXN + 1];
SegTree SegT[40 * MAXN];
int RootPos[MAXN + 1];
int cnt;

void BuildSegTree(int &id, int lef, int rig)
{
    id = ++cnt;
    nowp.val = 0;
    if (lef == rig)
        return;
    int mid = (lef + rig) / 2;
    BuildSegTree(lson, lef, mid);
    BuildSegTree(rson, mid + 1, rig);
}

void AddNum(int &id, int last, int x, int lef, int rig)
{
#define nval SegT[id].val
    id = ++cnt;
    lson = SegT[last].lef;
    rson = SegT[last].rig;
    nval = SegT[last].val + 1;
    if (lef == rig)
        return;
    int mid = (lef + rig) / 2;
    if (x <= mid)
        AddNum(lson, lson, x, lef, mid);
    else
        AddNum(rson, rson, x, mid + 1, rig);
#undef nval
}

int getRankN(int id, int _id, int ranks, int lef, int rig) //第几小
{
#define _lson SegT[_id].lef
#define _rson SegT[_id].rig
    if (lef == rig)
        return lef;
    int mid = (lef + rig) / 2;
    int SpotNum = SegT[_lson].val - SegT[lson].val;
    if (SpotNum >= ranks)
        return getRankN(lson, _lson, ranks, lef, mid);
    return getRankN(rson, _rson, ranks - SpotNum, mid + 1, rig);
#undef _lson
#undef _rson
}

int main()
{

#ifdef ONLINE_JUDGE
    std::ios::sync_with_stdio(false);
#else
    freopen("in", "r", stdin);
    freopen("out", "w", stdout);
#endif

    int caseN;
    cin >> caseN;
    while (caseN--)
    {
        int N, Q;
        cin >> N >> Q;
        cnt = 0;
        v.clear();
        for (int i = 1; i <= N; i++)
        {
            cin >> num[i]; //改scanf
            v.push_back(num[i]);
        }
        sort(v.begin(), v.end());
        v.erase(unique(v.begin(), v.end()), v.end()); //erase在getid中有用
        int T = v.size();
        BuildSegTree(RootPos[0], 1, T);
        for (int i = 1; i <= N; i++)
        {
            AddNum(RootPos[i], RootPos[i - 1], getid(num[i]), 1, T);
        }
        int left, right, ranks;
        while (Q--)
        {
            cin >> left >> right >> ranks;
            int index = getRankN(RootPos[left - 1], RootPos[right], ranks, 1, T);
            cout << v[index - 1] << endl;
        }
    }
    return 0;
}