#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    string removeOuterParentheses(string S)
    {

        string ans = "";
        int l = 0, r = 0;
        int mark = 0;
        for (char c : S)
        {
            if (c == '(')
            {
                r++;
            }
            else
            {
                r--;
            } 
            if (r == 0)
            {
                ans.erase(ans.begin() + mark);
                mark = ans.size();
            }
            else
            {
                ans.push_back(c);
            }
        }
        return ans;
    }
};

int main()
{
    Solution s;
    string k = s.removeOuterParentheses("(()())(())");
    cout << k << endl;
    return 0;
}