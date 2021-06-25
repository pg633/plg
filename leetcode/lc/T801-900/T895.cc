#include <bits/stdc++.h>
using namespace std;

class FreqStack
{
private:
    map<int, int> _freq;
    map<int, stack<int>> _g_item;
    int _max_item;

public:
    FreqStack()
    {
        _max_item = 0;
    }

    void push(int x)
    {
        _freq[x] ++;
        _g_item[_freq[x]].push(x);
        _max_item = max(_max_item, _freq[x]);
    }

    int pop()
    {
        int x = _g_item[_max_item].top();
        _g_item[_max_item].pop();    _freq[x]--;
        if (_g_item[_max_item].size() == 0)
        {
            _max_item--;
        }
        return x;
    }
};
 