#include <iostream>
#include <regex>
using namespace std;

class Solution {
public:
    bool checkRecord(string s) {
        int Absent=0;
        for(int i=0;i<s.size();i++)
            if(s[i]=='A')
                Absent++;
        if(Absent>1||s.find("LLL")!=string::npos)
            return false;
        return true;  
    }

}; 
int main(){
   string s  ("aaaa");
   string s2 {"asdasd"};
   cout<<s2<<endl;
   if(s.find("LLL")!=string::npos) cout<<"111111"<<endl;
   
   return 0;

}         