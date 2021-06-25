class Solution(object):
    def orderOfLargestPlusSign(self, N, mines):
        base = {tuple(mine) for mine in mines}
        dp = [[0]*N for _ in range(N)]
        ans = 0 
        for r in xrange(N):
            count = 0 
            for c in xrange(N):
                count = 0 if  (r,c) in base else count+1
                dp[r][c] = count
            count = 0
            for c in xrange(N-1,-1,-1):
                count = 0 if  (r,c) in base else count+1
                dp[r][c] = min(count,dp[r][c])

        for c in xrange(N):
            count = 0 
            for r in xrange(N):
                count = 0 if  (r,c) in base else count+1
                dp[r][c] = min(count,dp[r][c])
            count = 0
            for r in xrange(N-1,-1,-1):
                count = 0 if  (r,c) in base else count+1
                dp[r][c] = min(count,dp[r][c])
                ans = max(ans,dp[r][c])
        return ans



print(Solution().orderOfLargestPlusSign(5,[[4, 2]]))
print(min(1,2) )