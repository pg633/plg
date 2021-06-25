class Solution
{
public:
    int findShortestSubArray(vector<int> &nums)
    {
        int res = INT_MAX, degree = 0;
        unordered_map<int, int> l;
        unordered_map<int, pair<int, int>> r;
        for (int i = 0; i < nums.size(); i++)
        {
            if (l.find(nums[i]) == l.end())
            {

                r[nums[i]] = {i, i};
            }
            else
            {
                r[nums[i]].second = i;
            }
            degree = max(degree, ++l[nums[i]]);
           
        }
         cout <<degree <<endl;
        for (auto &it : l)
        {
            if (it.second == degree)
            {
                res = min(res, r[it.first].second - r[it.first].first);
                cout<< r[it.first].second  << "  " <<  r[it.first].first<<endl;
            }
        }

        return res+1;
    }
};