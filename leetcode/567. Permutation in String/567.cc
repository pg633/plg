#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int m[256],m2[256];
        for(char & c : s2){
            m[c]++;
        }
        for(char & c:s1){
            m2[c]++;
        }
        for(int i=0;i<256;i++){
            if(m2[i] > m[i]) return false; 
        }
        return true;
    }
};
int main(){
    Solution s;
    cout<< s.checkInclusion("asd","asda") <<endl;;
}

