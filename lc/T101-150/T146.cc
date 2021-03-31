#include <bits/stdc++.h>
using namespace std;

class LRUCache
{
private:
    int _size;
    list<int> _list;
    map<int, pair<int, list<int>::iterator>> _map;

private:
    void update_cache(map<int, pair<int, list<int>::iterator>>::iterator it)
    {

        _list.erase(it->second.second);
        _list.push_front(it->first);
        it->second.second = _list.begin();
    }

public:
    LRUCache(int capacity)
    {
        _size = capacity;
    }

    int get(int key)
    {
        auto it = _map.find(key);
        if (it != _map.end())
        {
            update_cache(it);
            return it->second.first;
        }
        return -1;
    }

    void put(int key, int value)
    {
        auto it = _map.find(key);
        if (it != _map.end())
        {
            update_cache(it);
        }
        else
        {
            if (_size == _list.size())
            {
                //满了
                _map.erase(_list.back());
                _list.pop_back();
            }
            _list.push_front(key);
        }

        _map[key] = make_pair(value, _list.begin());
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
int main()
{
}