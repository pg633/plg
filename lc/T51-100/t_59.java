class Solution {
    public int[][] generateMatrix(int n) {
        int [][] a = new int[n][n];
        int u = 0;
        int d = n-1;
        int l=0;
        int r =n-1;
        int ans =0;
        while(u<=d && l<=r){
            ans = p(a,u,d,l,r,ans);
            u++;d--;l++;r--;
        }
        return a;
    }
    private int p(int[][]a ,int u,int d,int l,int r,int ans){
        if(l==r){
            for(int i=u;i<=d;i++)
                a[i][l]=++ans;
        }else if(u==d){
            for(int i=l;i<=r;i++)
                a[u][i]=++ans;
        }else{
            for(int i=l;i<=r;i++)
                a[u][i]=++ans;
            for(int i=u+1;i<=d;i++)
                a[i][r]=++ans;
            for(int i=r-1;i>=l;i--)
                a[d][i]=++ans;
            for(int i=d-1;i>u;i--)
                a[i][l]=++ans;

        }
        return ans;
    }

}