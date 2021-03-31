class Solution {
public:
    int maximumSwap(int num) {
        stringstream ss ;
        ss<< num;
        string s;
        ss>> s; 
      
        for(int i=0;i<s.size();i++){
            int mx = 0;
            for(int j=i;j<s.size();j++){
                mx = max(mx,s[j]);
            }
            if(s[i] == mx) continue;
            for(int j=s.size()-1;j>i+1;j--){
                if(s[j] == mx) {
                    s[j] = s[i];
                    s[i] = mx;
                    return itoa(s);
                }
            }
        }
        return num; 
};