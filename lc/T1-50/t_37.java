package leetcoder;
class Solution {
    int f(int i,int j){
        return 3*(i/3)+j/3+1;
    }
    public void solveSudoku(char[][] b) {
        int[][] k = new int[10][10];
        int[][] p = new int[10][10];
        int[][] q = new int[10][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(b[i][j]!='.'){
                    k[i][b[i][j]-'0']=1;
                    p[j][b[i][j]-'0']=1;
                    q[f(i,j)][b[i][j]-'0']=1;
                }
            }
        }
        dfs(k,p,q,b,0,0);
    }

    boolean dfs(int[][]k,int[][]p,int[][]q,char[][]b,int i,int j){
        if(j==9)return true;
        if(b[i][j]!='.'){
            if(i+1<9){
                boolean rst = dfs(k,p,q,b,i+1,j);
                if(rst) return true;
            }else {
                boolean rst = dfs(k,p,q,b,0,j+1);
                if(rst) return true;
            }
        }else {
            for(int x = 1 ;x<=9;x++ ){
                if(k[i][x]!=1 &&  p[j][x]!=1&& q[f(i,j)][x]!=1){
                    k[i][x]=1;
                    p[j][x]=1;
                    q[f(i,j)][x]=1;
                    b[i][j]=(char)(x+'0');

                    if(i+1<9){
                        boolean rst = dfs(k,p,q,b,i+1,j);
                        if(rst) return true;
                    }else {
                        boolean rst = dfs(k, p, q, b, 0, j + 1);
                        if (rst) return true;
                    }


                    k[i][x]=0;
                    p[j][x]=0;
                    q[f(i,j)][x]=0;
                    b[i][j]='.';
                }
            }
        }
        return false;
    }
}
