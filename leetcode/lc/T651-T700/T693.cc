class Solution {
public:
    bool hasAlternatingBits(int n) {
        int  flag= n&1;
        while(n){
            n>>=1;
            if(!(flag ^ (n&1))){
                return false;        
            }
            flag = !flag;
            
        }
        return true;
    }
};