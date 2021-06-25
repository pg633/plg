class Solution
{
public:
    vector<int> constructArray(int n, int k)
    {
        vector<int> resVec(n, 0);
        int numK = k + 1, numTemp = 1;
        for (int i = 0; i <= k; i += 2)
        {
            resVec[i] = numTemp++;
        }
        for (int i = 1; i <= k; i += 2)
        {
            resVec[i] = numK--;
        }
        for (int i = k + 1; i < n; ++i)
        {
            resVec[i] = i + 1;
        }
        return resVec;
    }
};