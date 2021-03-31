class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        if(nums.size()<=1) return true;
        int cnt  =0 ; 
        for(int i=1;i<nums.size();i++){
            if(nums[i-1] <= nums[i]) continue;
            if(i-2>=0 && nums[i-2] > nums[i]){
                nums[i] = nums[i-1];
            }
            else{
                nums[i-1]= nums[i] ;
            }
            cnt++;
        }
        return cnt <=1;
    }
};