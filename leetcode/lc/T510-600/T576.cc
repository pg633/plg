class Solution {
public:
    /*
    int findPaths(int m, int n, int N, int i, int j) {
         if(i<0||j<0||i==m||j==n) return 1;
        if(N==0) return 0;
        return (findPaths(m,n,N-1,i-1,j)+
                findPaths(m,n,N-1,i,j-1)+
                findPaths(m,n,N-1,i+1,j)+
                findPaths(m,n,N-1,i,j+1)) % (int)(1e9+7);
    }*/
    
    int findPaths(int m, int n, int N, int i, int j) {
        if(N==0)  return 0;
        long  dp [N][m+2][n+2]  ;
        memset(dp,0,sizeof(dp));
  
        dp[0][i+1][j+1] =1;
        
        long res = 0 ;
        int mod = (int)1e9+7;
        if(i==0) res++;
        if(i==m-1) res++;
        if(j==0) res++;
        if(j==n-1) res++;
        for(int a =1;a<N;a++)
            for(int b=1;b<=m;b++)
                for(int c=1;c<=n;c++){
                    dp[a][b][c] = (dp[a-1][b-1][c] +
                        dp[a-1][b][c-1] +
                        dp[a-1][b][c+1] +
                        dp[a-1][b+1][c] )%mod;
                    if(b==1)
                        res =(res+dp[a][b][c])%mod;
                    if(b==m) res =(res+dp[a][b][c])%mod;
                       
                        if(c==1)
                        res =(res+dp[a][b][c])%mod; 
                            if(c==n)
                        res =(res+dp[a][b][c])%mod;   

                }
        return int(res);
    }
};