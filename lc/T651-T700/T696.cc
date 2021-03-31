class Solution
{
public:
    int countBinarySubstrings(string s)
    {
        int res = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++)
        {
            if (s[i] == s[i - 1])
            {
                ++cur;
            }
            else
            {
                pre = cur;
                cur = 1;
            }
            if (cur <= pre)
                ++res;
        }
        return res;
    }
};