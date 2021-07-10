#include <bits/stdc++.h>
using namespace std;

struct FinTree {
    vector<int> v ;
    int size ;
    FinTree(int _size):size(_size){
        v = vector<int>(size,0);
    }
    int lowbit(int n) {
        return n& -n;
    }
    void updateTree(int i ,int count){
        while(i<size) {
            v[i] +=count;
            i+= lowbit(i);
        }
    }
    int queryTree(int i){
        int res= 0 ;
        while(i>0){
            res+=v[i];
            i -= lowbit(i);
        }
        return res;
    }
};

class Solution
{
public:
    int reversePairs(vector<int> &nums)
    {
        int len = nums.size();
        if (len == 0)
            return 0;
        vector<int> v(nums.begin(), nums.end());
        //离散化
        sort(v.begin(), v.end());
        v.erase(unique(v.begin(), v.end()), v.end());

        FinTree ft(len + 1);
        int count = 0;
        for (int i = len - 1; i >= 0; i--)
        {
            count += ft.queryTree(lower_bound(v.begin(), v.end(), ceil(nums[i] / 2.)) - v.begin());
            ft.updateTree(lower_bound(v.begin(), v.end(), nums[i]) - v.begin() + 1, 1);
        }
        return count;
    }
};

int main()
{
    vector<int> v{1, 3, 2, 3, 1};
    Solution s;
    cout<< s.reversePairs(v);
}