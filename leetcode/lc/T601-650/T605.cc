#include <string> 
#include <stringstream>
class Solution {
public:
    int minSteps(int n) {
      
        stringstream ss;
        ss<<n<<std::basic_ostream;
        string s  ;
        ss>>s; 
        int ret = 0;
        for(auto c :s ){
            if(c=='1'){
                ret +=2 ;
            }else{
                ret ++ ;
            }
        }
        return ret;
    }
};