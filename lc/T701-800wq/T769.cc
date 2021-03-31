class Solution
{
public:
    int maxChunksToSorted(vector<int> &arr)
    {
        int res = 0;
        for (int i = 0; i < arr.size();)
        {
            int j = i + 1;
            for (; j <= arr[i]; j++)
            {
                if (arr[j] > arr[i])
                {
                    break;
                }
            }
            if (j <= arr[i])
            {
                i = j;
            }
            else
            {
                res++;
                i = arr[i] + 1;
            }
        }
        return res;
    }
};