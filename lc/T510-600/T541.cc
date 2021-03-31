
#include<string>
#include <iostream>
using namespace std;

class Solution {
public:
    string reverseStr(string s, int k) {
        string res ="",tmp="";
        for(int i=0;i<s.length();i+=k){
            tmp = s.substr(i,k);
            if((i/k)%2==0){
                reverse(tmp.begin(),tmp.end());
            }
            res+=tmp;
        }
        return res;
    }
}; 