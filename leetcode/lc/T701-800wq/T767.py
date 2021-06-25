# class Solution:
# 	def reorganizeString(self, S):
# 		N = len(S)
# 		A = []
# 		for r,c in sorted((S.count(c),c ) for c in set(S)):
# 			if r > N/2:
# 				return ""
# 			else:
# 				A.append(c*r)
# 		ans = [None]*N	
# 		ans[::2] ,ans[1::2] = A[N/2:],A[:N/2]
# 		return "".join(ans)

class Solution(object):
    def reorganizeString(self, S):
        N = len(S)
        A = []
        for c, x in sorted((S.count(x), x) for x in set(S)):
            if c > (N+1)/2: return ""
            A.extend(c * x)
        ans = [None] * N
        ans[::2] = A[N//2:]
        ans[1::2] = A[:N//2]
        return "".join(ans)

a = Solution().reorganizeString("abc")
print(a)