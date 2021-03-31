
#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        map<int, int> m;
        for (int i = 0; i < numbers.size(); i++)
        {
            if (m.count(numbers[i]))
            {
                return {i+1, m[numbers[i]]};
            }
            m[target - numbers[i]] = i+1;
        }
        return {-1, -1};
    }
};

int main()
{
    vector<int> v{2, 7, 11, 15};
    Solution s;
    auto it = s.twoSum(v, 9);
    for (auto i : it)
        cout << i << " ";
    cout << endl;


    int n  =1 ; 
    cout<< ~n<<endl;
    return 0;
}

