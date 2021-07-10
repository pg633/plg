#include <iostream>
#include <algorithm>
#include <string>
using namespace std;



class Solution {
public:
    int nextGreaterElement(int n) {
        string s = to_string(n); 
        next_permutation(s.begin(),s.end());
        long long res =0;
        for(int i=0;i<s.size();i++){
            res = res*10+s[i]-'0';
            
        }
        if(res>INT_MAX) {
            return -1;
        }
        if(res <= n) return -1 ;
        else return res;
    }
};
int main(){
    Solution s;
    cout<<s.nextGreaterElement(12)<<endl;
}