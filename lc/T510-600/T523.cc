#include <iostream>
#include <vector>
using namespace  std;

class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        for(int i=0;i<nums.size()-1;i++){
            int sum = nums[i];
            for(int j=i+1;j<nums.size();j++){
                sum+=nums[j];
                if(sum == k || (k!=0 &&  sum%k==0)){
                    return  true;
                }
            }
        }
        return false;
    }
};