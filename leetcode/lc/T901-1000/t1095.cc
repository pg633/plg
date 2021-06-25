
#include <bits/stdc++.h>
using namespace std;

class MountainArray
{
private:
    vector<int> v{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82};

public:
    int get(int index)
    {
        if (index < 0 || index >= v.size())
        {
            cerr << " now in index " << index << endl;
        }
        return v[index];
    }
    int length()
    {
        return v.size();
    }
};

class Solution
{
public:
    int findInMountainArray(int target, MountainArray &mountainArr)
    {
        int id = getMaxIndex(target, mountainArr);
        cout << "id " << id << endl;
        if (id == -1)
            return -1;
        // return -1;
        auto res1 = bin_searchU(target, mountainArr, 0, id);
        auto res2 = bin_searchD(target, mountainArr, id, mountainArr.length() - 1);
        if (res1 == -1 && res2 == -1)
            return -1;
        else if (res1 == -1)
            return res2;
        else if (res2 == -1)
            return res1;
        return res1;
    }
    int bin_searchU(int target, MountainArray &mountainArr, int l, int r)
    {
        while (l <= r)
        {
            int mid = (l + r) / 2;
            int mid_r = mountainArr.get(mid);
            if (mid_r == target)
                return mid;
            else if (mid_r < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    int bin_searchD(int target, MountainArray &mountainArr, int l, int r)
    {
        while (l <= r)
        {
            int mid = (l + r) / 2;
            int mid_r = mountainArr.get(mid);
            if (mid_r == target)
                return mid;
            else if (mid_r < target)
                r = mid - 1;
            else if (mid_r > target)
                l = mid + 1;
        }
        cerr << "in return bin_searchD " << l << endl;
        return -1;
    }
    int getMaxIndex(int target, MountainArray &mountainArr)
    {
        int l = 0;
        int r = mountainArr.length() - 1;
        while (l < r)
        {
            int mid = (l + r) / 2;
            // cout << "mid  " << mid <<    " l "<< l << "r " << r <<endl;
            int l1 = mountainArr.get(mid);
            int m1 = mountainArr.get(mid + 1);
            if (l1 < m1)
                  l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
};

int main()
{
    Solution s;
    MountainArray m;
    cout << s.findInMountainArray(81, m) << endl;
    // cout << m.length() << endl;
    // for (int i = 0; i < m.length(); i++)
    // {
    //     if (m.get(i) == 101)
    //         cout << i << endl;
    // }
    cout << s.bin_searchD(81, m, 60, m.length() - 1) << endl;
}
