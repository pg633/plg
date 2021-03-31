

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> pancakeSort(vector<int> &A)
    {
        vector<int> res;
        sort(A, A.size(), res);
        return res;
    }
    void sort(vector<int> &A, int n, vector<int> &res)
    {
        if (n == 1)
            return;
        {
            for (auto i : A)
                cout << i << " ";
            cout << endl;
        }
        int maxn = A[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++)
        {
            if (maxn < A[i])
            {
                maxn = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex == 0)
        {
            reverse(A, 0, n);
            res.push_back(n);
        }
        else
        {
            reverse(A, 0, maxIndex + 1);
            res.push_back(maxIndex + 1);
            reverse(A, 0, n);
            res.push_back(n);
        }
        sort(A, n - 1, res);
    }
    void reverse(vector<int>& v, int from, int to)
    {
        ::reverse(v.begin() + from, v.begin() + to);
    }
};

class Solution1
{
public:
    vector<int> pancakeSort(vector<int> &A)
    {
        vector<int> V;
        int temp = 0; //每一次循环最大的元素一定在正确位置，所以使用temp来缩短遍历长度
        for (int j = 0; j < A.size(); j++)
        {
            int max = -1, index = 0;
            for (int i = 0; i < A.size() - temp; i++) //寻找剩余元素中的最大值，返回其下标
            {
                if (max < A[i])
                {
                    max = A[i];
                    index = i;
                }
            }
            if (index == 0) //如果最大值恰好在第一个元素位置，那么直接进行翻转A.size() - temp长度将其转到剩余元素的最大位置
            {
                V.push_back(A.size() - temp);
                reverseK(A, A.size() - temp);
            }
            else
            {
                V.push_back(index + 1); //先将其翻转到第一个元素位置
                reverseK(A, index + 1);
                V.push_back(A.size() - temp); //再将第一个元素位置翻转到剩余元素最大值位置
                reverseK(A, A.size() - temp);
            }
            temp++;
        }
        return V;
    }

private:
    void reverseK(vector<int> &v, int k) //翻转vector的前k个元素
    {
        ::reverse(v.begin(), v.begin() + k);
    }
};

int main()
{
    {
        Solution1 s;
        vector<int> v{3, 2, 4, 1};
        auto it = s.pancakeSort(v);
        for (auto i : it)
        {
            cout << i << " ";
        }
        cout << endl;
    }

    {
        Solution s;
        vector<int> v{3, 2, 4, 1};
        auto it = s.pancakeSort(v);
        for (auto i : it)
        {
            cout << i << " ";
        }
        cout << endl;
    }

    return 0;
}
// 1 3 2 4
