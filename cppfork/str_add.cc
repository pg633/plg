#include <bits/stdc++.h>
using namespace std; //

string calc(string a, string b)
{
    vector<int> v(a.size() + b.size(), 0);
    for (int i = a.size() - 1; i >= 0; i--)
        for (int j = b.size() - 1; j >= 0; j--)
        {
            int k = (a[i] - '0') * (b[j] - '0');
            int p1 = i + j;
            int p2 = i + j + 1;
            k += v[p2];
            v[p1] += k / 10;
            v[p2] = k % 10;
        }
    int i = 0;
    while (i < v.size() && v[i] == 0)
        ++i;
    string s;
    for (; i < v.size(); ++i)
        s += (v[i] + '0');
    return s == "" ? "0" : s;
}

int main()
{
    string a, b;
    cin >> a >> b;
    cout << calc("4", "15") << endl;
}