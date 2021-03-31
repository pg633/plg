#include <iostream>
#include <string>
using namespace std;



class Solution {
public:
    string reverseWords(string s) {
        int pos,space = 0;
        while((pos = s.find_first_not_of(" ",space)) != string::npos){
            space = s.find_first_of(" ",pos);
            if(space!=string::npos){
                reverse(s.begin()+pos,s.begin()+space);
            }else{
                reverse(s.begin()+pos,s.end());
            }
        }
        return s;
    } 
};



int main(){
    string s1 ("asd dsa fff");
    Solution s;
    auto x = s.reverseWords(s1);
    cout<<x<<endl;



}