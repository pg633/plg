#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int,int> m ;
        m[0] =1;
        int sum=0,ret =0 ;
        for(auto & t:nums){
            sum+=t;
            ret += m[sum-k];
            m[sum]++; 
        } 
        return ret; 
    }
};
int main(){
    vector<int> a {1};
    Solution s;
    cout<<s.subarraySum(a,0)<<endl;
}