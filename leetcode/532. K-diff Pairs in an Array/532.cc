
#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int res = 0;
        for(int i=0;i<nums.size();i++){
            if(i==0 || (i!=0 &&nums[i]!=nums[i-1]))
            for(int j=i+1;j<nums.size() ;j++){
                 if(nums[j] - nums[i] > k )break;
                 else if (nums[j] - nums[i]==k) {
                     res++;
                     break;
                 }

            }
        }        
        return res;
    }
}; 

 