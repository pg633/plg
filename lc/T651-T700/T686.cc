class Solution {
public:
    int repeatedStringMatch(string A, string B) {
        string tmp = A;
        int cnt = 1; 
        int mid = V.size()/ A.size();
        while(cnt<=mid +2 ){
            if(tmp.find(B) != string::npos){
                return cnt;
            }
            tmp+=A;
            cnt++;
        }
        return  -1;
        
    }
}; 