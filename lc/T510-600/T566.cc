#include <iostream>
#include <vector>
using namespace std;




class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int n = nums.size();
        int m = nums[0].size();
        if(n*m !=r*c) return nums;
        vector<vector<int>> v  (r,vector<int>(c,0));
        int l =0; 
        int ll =0 ;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                v[i][j] = nums[l][ll];
                ++ll == m ? ++l,ll=0 :0;
            }
        }
        return v;
    }
};


int main(){
    vector<vector<int>> nums {{1,2},{3,4}};
    Solution s ;
    auto v = s.matrixReshape(nums,1,4);
    for(auto & vv : v){
        for_each(vv.begin(),vv.end(),[](int & k){cout<<k<<" ";});
        cout<<endl;
    }


}