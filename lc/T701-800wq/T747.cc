
class Solution {
public:
    int dominantIndex(vector<int>& nums) {
         int mm = nums[0]; int pos =0;
         for(int i=0;i<nums.size();i++){
             if(mm < nums[i]){
                 mm = nums[i];
                 pos = i;
             }
         }
         for(auto it :nums){
                mm = max(mm,it);
         }
         for(auto it :nums){
               if(it !=mm & it*2>mm) return -1;
         }
         return pos;
         
    }
};