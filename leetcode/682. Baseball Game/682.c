class Solution {
public:
    int calPoints(vector<string>& ops) {
         vector<int>  v(ops.size(),0) ;
        int i =0; 
        for(string s : ops){
            if(s == "C"){
                v[i-1] = 0 ; i--;
            }else if(s == "D"){
                v[i] = v[i-1]*2;i++;
            }else if(s == "+"){
                v[i] = v[i-1]+v[i-2];
                
                i++;
            }else{
                v[i] = stoi(s);
                i++;
            }
         //   cout<< v[i-1]<<endl;
        }
        return accumulate(v.begin(),v.end(),0);  
    }
};