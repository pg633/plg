class Solution
{
public:
    int findLengthOfLCIS(vector<int> &nums)
    {
        if(nums.size()==0) return 0;
        int from = 0;
        int to = 1;
        int mx = 0;
        while (to < nums.size())
        {
            if (nums[to] > nums[to - 1])
            {
                to++;
                continue;
            }
            else
            {
                mx = max(mx, to - from);
                from = to;
            }
            to++;
        }
        mx = max(mx, to - from);
        return mx;
    }
};