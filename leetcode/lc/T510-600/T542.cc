#include <iostream>
#include <vector>
#include <queue>
using namespace std;


class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
         int m=matrix.size(),n=matrix[0].size();
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(!matrix[i][j])q.push(make_pair(i,j));
                else matrix[i][j]=-1;
            }
        
        while(!q.empty()){
            pair<int,int> t=q.front();q.pop();
            int x=t.first,y=t.second;
            int dir[4][2]={{-1,0},{1,0},{0,1},{0,-1}};
            for(int i=0;i<4;i++){
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&matrix[nx][ny]==-1){
                    matrix[nx][ny]=matrix[x][y]+1;
                    q.push(make_pair(nx,ny));
                }
            }
        }
        return matrix;
    } 
}; 


int main(){

}