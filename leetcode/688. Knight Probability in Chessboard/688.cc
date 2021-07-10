class Solution {
public:
    double knightProbability(int N, int K, int r, int c) {
        vector<vector<vector<double> > > dp (N+4,vector<vector<double> >>(N+4,vector<double>(2,0)));
        for(int i = 0; i <N+4;i++)
        for(int j = 0; j<N+4;j++){
            if( i<2 || j<2 || i>=N+2||j>=N+2 )
            dp[i][j][0] = dp[i][j][1] = 1 ;
         }

        bool tag = true;
        while(K--){
            for(int i = 2; i<=N+2;i++){
                for(int j = 2; j<=N+2;j++){
                    dp[i][j][tag] = (
                               dp[i - 1][j - 2][!tag] + dp[i - 1][j + 2][!tag] + 
                         dp[i - 2][j - 1][!tag] + dp[i - 2][j + 1][!tag] +
                         dp[i + 1][j + 2][!tag] + dp[i + 1][j - 2][!tag] + 
                         dp[i + 2][j + 1][!tag] + dp[i + 2][j - 1][!tag]
                    )/8;
                    tag = !tag;
                }
            }

        }
        return 1 - dp[r+2][j+2][!tag]; 
    }
};