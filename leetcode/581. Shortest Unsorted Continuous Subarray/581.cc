#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        vector<int> v  (nums.begin(),nums.end());
        sort(v.begin(),v.end());
        int res = 0;
        for(int i=0;i<v.size()&& v[i]== nums[i];i++) res++;        
        for(int i=v.size()-1;i>=0&& v[i]== nums[i];i--) res++;    
        return (nums.size() > res) ? ( nums.size()-res):0;
    
    }
};



int main(){
    vector<int> v {1,2,3,4};
    Solution s ;
    int n = s.findUnsortedSubarray(v);
    cout<<n<<endl;
    cout<<"asdasd"<<endl;
}