class Solution {
public:
    bool iszero(double a){
        return fabs(a)<=1e-6;
    }
    bool work(vector<double> t){
        if(t.size()==1)return iszero(t[0]-24.0);
        for(int i=0;i<t.size()-1;++i){
            for(int j=i+1;j<t.size();++j){
                vector<double> y;
                for(int k=0;k<t.size();++k){
                    if(k!=i&&k!=j)y.push_back(t[k]);
                }
                {
                    auto l=y;
                    l.push_back(t[i]+t[j]);
                    if(work(l))return true;
                }
                {
                    auto l=y;
                    l.push_back(t[i]-t[j]);
                    if(work(l))return true;
                }
                {
                    auto l=y;
                    l.push_back(t[j]-t[i]);
                    if(work(l))return true;
                }
                {
                    auto l=y;
                    l.push_back(t[i]*t[j]);
                    if(work(l))return true;
                }
                {
                    auto l=y;
                    if(t[j]){
                        l.push_back(t[i]/t[j]);
                        if(work(l))return true;
                    }
                }
                {
                    auto l=y;
                    if(t[i]){
                        l.push_back(t[j]/t[i]);
                        if(work(l))return true;
                    }
                }
            }
        }
        return false;
    }
    bool judgePoint24(vector<int>& nums) {
        int vis[4]={0,0,0,0};
        vector<double> t;
        for(auto i:nums)t.push_back((double)i);
        return work(t);
    }
};