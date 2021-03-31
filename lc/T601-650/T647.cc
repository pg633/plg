 class Solution {
public:
    int countSubstrings(string s) {

         int ret =0 ;
    for(int i=0;i<s.length();i++){
         int l = i;
         int r = i;
         while(l>=0&&r<s.length()&&s[l]==s[r]){
             ret++;
             l--;
             r++;
         }
        l = i-1;
        r = i; 
        while(l>=0&&r<s.length()&&s[l]==s[r]){
             ret++;
             l--;
             r++;
         }
        
     }
        return ret;
        
    }
};