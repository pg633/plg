class Solution
{
public:
    int numJewelsInStones(string J, string S)
    {
        set<char> s(J.begin(), J.end());

        int n = 0;
        for (auto c : S)
        {
            if (s.count(c))
            {
                n++;
            }
        }
        return n;
    }
};
 