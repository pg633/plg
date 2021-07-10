class Solution
{
public:
    bool validPalindrome(string s)
    {
        int l = 0;
        int r = s.size() - 1;
        while (l < r)
        {
            if (s[l] == s[r])
            {
                l++;
                r--;
            }
            else
            {
                return search(s, l + 1, r) || search(s, l, r - 1);
            }
        }
        return true;
    }
    bool search(string s, int l, int r)
    {
        while (l < r)
        {
            if (s[l] == s[r])
            {
                l++, r--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
};