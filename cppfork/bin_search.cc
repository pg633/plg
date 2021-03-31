#include <bits/stdc++.h>
using namespace std;

int bin_search(vector<int> &v, int target)
{
    int left = 0, right = v.size() - 1;
    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        if (v[mid] == target)
        {
            return mid;
        }
        else if (v[mid] < target)
        {
            left = mid + 1;
        }
        else if (v[mid] > target)
        {
            right = mid - 1;
        }
    }
    return -1;
}

int left_bound(vector<int> v, int target)
{
    int left = 0;
    int right = v.size();
    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        if (v[mid] < target)
            left = mid + 1;
        else if (v[mid] > target)
            right = mid - 1;
        else if (v[mid] == target)
            right = mid - 1;
    }
    if (left > v.size() || v[left] != target)
        return -1;
    return left;
}

int r_search(vector<int> &v, int target)
{
    int l = 0;
    int r = v.size();
    while (l <= r)
    {
        int mid = (l + r) / 2;
        if (v[mid] == target)
            l = mid + 1;
        else if (v[mid] < target)
            l = mid + 1;
        else if (v[mid] > target)
            r = mid - 1;
    }
    if (r < 0 || v[r] != target)
        return -1;
    return r;
}

int main()
{
    vector<int> v{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14};
    cout << bin_search(v, 10) << endl;
    cout << left_bound(v, 10) << endl;
    cout << r_search(v, 10) << endl;
    cout << lower_bound(v.begin(), v.end(), 10) - v.begin() << endl;
    cout << upper_bound(v.begin(), v.end(), 10) - v.begin()  << endl;
    return 0;
}