#include <bits/stdc++.h>
using namespace std;

class Solution1
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> map;
        int l = 0;
        int r = 0;
        int res = -1;

        while (r < s.size())
        {
            char c = s[r];
            map[c]++;
            r++;

            while (map[c] > 1)
            {
                map[s[l]]--;
                l++;
            }
            res = max(res, r - l);
        }
        return res;
    }
};

class Solution2
{
public:
    vector<int> findAnagrams(string s, string p)
    {
        int l = 0;
        int r = 0;
        unordered_map<char, int> m1, m2;
        for (auto c : p)
            m2[c]++;
        int match = 0;
        vector<int> res;
        while (r < s.size())
        {
            char c = s[r];
            if (m2.count(c))
            {
                m1[c]++;
                if (m1[c] == m2[c])
                {
                    match++;
                }
            }
            r++;
            while (match == m2.size())
            {
                if (r - l == p.size())
                    res.push_back(l);
                char c2 = s[l];
                if (m2.count(c2))
                {
                    m1[c2]--;
                    if (m1[c2] < m2[c2])
                        match--;
                }
                l++;
            }
        }
        return res;
    }
};
class Solution
{
public:
    string minWindow(string s, string t)
    {
        int l = 0;
        int r = 0;
        unordered_map<char, int> m1, m2;
        string res = "";
        int match = 0;
        int start = 0;
        int min_len = INT_MAX;
        for (auto c : t)
            m2[c]++;
        while (r < s.size())
        {
            char c = s[r];
            m1[c]++;

            if (m2.count(c) && m2[c] == m1[c])
            {
                match++;
            }
            r++;

            while (match == m2.size())
            {
                if ( res == "" || res.size() > r-l)
                {
                    cout<< res << " " << l << " " << r  << " " <<endl;
                    res = s.substr(l,r-l);
                }
                char c2 = s[l];
                m1[c2]--;
                l++;
                if (m2.count(c2) && m2[c2] > m1[c2])
                    match--;
            }
        }
        return res;
    }
};

string minWindow(string s, string t)
{
    // 记录最短子串的开始位置和长度
    int start = 0, minLen = INT_MAX;
    int left = 0, right = 0;

    unordered_map<char, int> window;
    unordered_map<char, int> needs;
    for (char c : t)
        needs[c]++;

    int match = 0;

    while (right < s.size())
    {
        char c1 = s[right];
        if (needs.count(c1))
        {
            window[c1]++;
            if (window[c1] == needs[c1])
                match++;
        }
        right++;

        while (match == needs.size())
        {
            if (right - left < minLen)
            {
                // 更新最小子串的位置和长度
                start = left;
                minLen = right - left;
            }
            char c2 = s[left];
            if (needs.count(c2))
            {
                window[c2]--;
                if (window[c2] < needs[c2])
                    match--;
            }
            left++;
        }
    }
    return minLen == INT_MAX ? "" : s.substr(start, minLen);
}
int main()
{
    Solution s;
    // cout << s.lengthOfLongestSubstring("abcabcbb");
 
    auto it = s.minWindow("cabwefgewcwaefgcf", "cae");
    // for(auto i : it) cout<<i <<endl;
    cout << it << endl;

}
