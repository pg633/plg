#include <iostream>
#include <string>
#include <sstream>
using namespace std;


class Solution {
public:
    string complexNumberMultiply(string a, string b) {
        int  k1 = a.find('+');
        int  k2 = b.find('+'); 
        int n1 = parse(a.substr(0,k1));
        int n2 = parse(a.substr(k1+1));
        int m1 = parse(b.substr(0,k2));
        int m2 = parse(b.substr(k2+1));
        int l1 = n1 * m1 - n2*m2;
        int l2 = n1*m2+n2*m1;
         
        return to_string(l1)+ "+"+to_string(l2)+"i"; 
    }
    int parse(string  s){
        if(s[s.size()-1] == 'i'){
            s = s.substr(0,s.size()-1);
        }
        stringstream stream(s);
        int res = 0;
        stream>> res;
        return res;
       
    }
};
int main(){
    Solution s;
    cout << s.complexNumberMultiply("1+1i", "1+1i")<<endl;

}
   
  
  