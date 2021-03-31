#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


class Solution {
public:
    string fractionAddition(string expression) {
        vector<string> v ;
        vector<char>  c ; 
        split(expression,v,c);
        return v;
    }
    vector<string>  split(string s,vector<string> & v,vector<char> & cs){


        return {};
    }

    // struct f{
    //     int  up,down ;
    //     f(int up,int down){
    //         this->up = up;
    //         this->down = down;
    //     }
      
    // }; 

};


int main(){
    Solution s;
    auto s = s.fractionAddition("-1/2+1/2");
    cout<<s <<endl;
    
}