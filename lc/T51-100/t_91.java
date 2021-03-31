class Solution {
    public int numDecodings(String s) {
        return dfs(s.toCharArray(),0,0,false )/2;
    }
    int dfs(char []a ,int now ,int tmp,boolean flag){
        if(now == a.length){
            return 1;

        }
        int res = 0;
        int k = a[now] -'0';
        tmp = tmp * 10 + k;

        if(flag){
            if(tmp >0 && tmp<=26){
                res+=dfs(a,now+1,tmp,true);
                res+=dfs(a,now+1,0,false );

            }
        }else{
            // k
            if(tmp!=0)
            {
                res += dfs(a, now + 1, tmp, true);
                res += dfs(a, now + 1, 0, false);
            }
        }



        return res;
    }
}



class Solution1 {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()];

        if (arr[arr.length - 1] != '0')
            dp[arr.length - 1] = 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == '0')
                continue;
            else if (arr[i] == '1' || (arr[i] == '2' && arr[i + 1] <= '6')) {
                if( i == arr.length - 2)
                    dp[i] =  dp[i + 1] + 1 ;
                else dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }

        }
        return dp[0];
    }
}


