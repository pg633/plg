class Solution {
public:
    bool isPossible(vector<int>& nums) {
        vector<pair<int,int>> res ;
        for(const auto & i :nums){
            bool use = false;
            for(auto it = res.rend(); it != res.rbegin(); ++it){
                if((*it).second == i-1) {
                    use = true;
                    (*it).second = i;
                    break;
                }
            }
            if(!use) res.emplace_back(make_pair(i,i));
        }
        for(const auto & it : res){
            if(it.second - it.second +1 < 3) return false;
        }
        return true;
    }
};


class Solution {
public:
    bool isPossible(vector<int>& nums) {
        vector<pair<int, int>> seqs;
        int n = nums.size();
        for(int i = 0;i < n; i++) {
            bool mark = false;
            int m = seqs.size();
            for(int j = m - 1; j >= 0; j--) {
                if(seqs[j].second == nums[i] - 1) {
                    seqs[j].second = nums[i];
                    mark = true;
                    break;
                }
            }
            if(!mark) {
                seqs.push_back(make_pair(nums[i], nums[i]));
            }
        }
        for(auto seq : seqs) {
            if(seq.second - seq.first + 1 < 3) {
                return false;
            }
        }
        return true;
    }
};

