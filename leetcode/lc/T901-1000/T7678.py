import collections  
class Solution:
    def maxChunksToSorted(self, arr):
        ba = collections.defaultdict(int)
        ans = nozone = 0
        for r,c in zip(arr,sorted(arr)):
            ba[r] += 1
            if ba[r] == 0 : nozone -=1
            if ba[r] == 1 :nozone +=1
            ba[c] -= 1
            if ba[c] ==-1 :nozone +=1
            if ba[c] == 0 :nozone -=1
            if nozone == 0: ans+=1
        return ans

Solution().maxChunksToSorted([5,4,3,2,1])
 