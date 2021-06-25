class Solution
{
public:
    int countPrimeSetBits(int l, int r)
    {
        set<int> s = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int cnt = 0;
        for (int i = l; i <= r; i++)
        {
            bitset<32> b(i);
            if (s.find(b.count()) != s.end())
            {
                cnt++;
            }
        }
        return cnt;
    }
};