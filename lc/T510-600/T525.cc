#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <initializer_list> 
#include <map>
#include <unordered_map>
using namespace  std;


class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int mx = 0;
        map<int,int> m ;
        int sum = 0;
        for(int i=0;i<nums.size();i++){
            sum+=(nums[i]==1?1:-1);
            if(sum==0){
                mx = i+1;
            }else {
                if(m[sum]==0){
                    m[sum] = i+1;
                }else {
                    mx = max(mx,i-m[sum]+1);
                }
                
            }
        }
         return mx;
    }
};
int main(){   
    Solution s;
    vector<int> v  {1,0};
    cout << s.findMaxLength(v) <<endl;
}