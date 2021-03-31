

class Solution {
    public List<Integer> getRow(int numRows) {

        int [][]dp = new int  [2][numRows+1];

        for(int i=0;i<=numRows;i++){

            dp[i%2][0] = 1;
            dp[i%2][i] = 1;
            for(int j=1;j<i;j++){

                dp[i%2][j] = dp[(i+1)%2][j]+dp[(i+1)%2][j-1];
            }

        }
        int i = numRows;
        int[]dd=Arrays.copyOfRange(dp[i%2],0,i+1);
        ArrayList<Integer> tt = new ArrayList<>();
        for(int td : dd){
            tt.add(td);
        }
        return tt;
    }
}