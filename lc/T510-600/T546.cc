#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    vector<int> v ;
    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size();
        v = vector<int>(n,0);
        for(int i = 0;i<n;i++) v[i] = i ;
        int res = M.size();
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && M[i][j]==1){
                    int ni = getf(i);
                    int nj = getf(j);
                    if(ni!=nj){
                        v[ni] = nj;
                        res--;
                    }
                }
            }
        }
        return res;
    } 
    int getf(int i){
        return v[i] == i ? i :v[i] = getf(v[i]);
     }
};
  