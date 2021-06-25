#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(amount < 0) return -1;
        vector<int> v (amount+1,0);
        v[0]=1;
        sort(coins.begin(),coins.end(),[](int & l,int & r){return l<r;});
        for(int & i : coins){
            for(int j=0;j+i<=amount;j++){
                v[j+i] += v[j];
            }
        } 
        return v[amount];
    }
};
n

int main(){
    Solution s;
    vector<int> v {1,2,5};
    cout<<s.change(5,v)<<endl;

    return 0;
}