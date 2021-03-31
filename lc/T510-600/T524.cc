#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <initializer_list> 
using namespace  std;


class Solution {
public:
    string findLongestWord(string s, vector<string>& d) {
        vector<string > t;
        for(string & ds : d){
            if(can(ds,s)){
                t.push_back(ds);
            }
        }
        // for_each(t.begin(),t.end(),[](string & s ){cout<<s<<endl;});
        sort(t.begin(),t.end(), [](string & l,string & r){
            if(l!=r )  return l.length() >  r.length();
             
            for(int i=0;i<l.length();i++){
                if(l[i]!=r[i]) return l[i]<r[i];
            } 
            return false;
        });
        for_each(t.begin(),t.end(),[](string & s ){cout<<s<<endl;});
        return t.size()==0 ?"":t[0];

    }
    bool can(string a,string b){
        int i = 0;
        for(auto & c : a ){
           for(;i<b.length();i++){
               if(c == b[i]){
                   break;
               }
           }
           i++;
           if(i>b.length()){
               return false;
           }
        }
        return true;
    }
};
int main(){
    Solution s;
    vector<string> v =  {"appel","apple","monkey","plea"}; 
    cout << s.findLongestWord("abpcplea", v)<<endl; 
}
