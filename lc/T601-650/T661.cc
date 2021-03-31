class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& M) {
        vector<vector<int>> v (M.size(),vector<int>(M[0].size(),0));
         int []dir = {-1,0,1};
        for(int i = 0; i < M.size();i++)
            for(int j = 0; j < M[i].size();j++){
                 int k =0 ;
                
                 int now = 0 ;
                 int c = 0 ;
                 for(int k = 0; k < 3;k++){
                     for(int l = 0; l<3 ;l++){
                         if(const(i+dir[k] ,j+dir[l],M.size(),M[0].size())){
                            c++;
                            now+=M[i+dir[k]][j+dir[l]];
                         }
                     }
                 }
                 v[i][j] = now/c;
            }
        return v;
    }
    bool cons(int i,int j,int n,int m){
        return i >=0 && j>=0 && i<n&&j<m;
    }
};