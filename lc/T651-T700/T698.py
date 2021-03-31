

#  使用记搜 完成遍历
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        target,rem = divmod(sum(nums),k)
        if rem : return False
        def dfs(g):
            if not nums: return True
            v = nums.pop()
            for i,group in enumerate(g):
                if group + v <= target:
                    g[i]+=v
                    if dfs(g) : return True
                    g[i]-=v
                if not group: break
            nums.append(v)
            return False
        nums.sort()
        if nums[-1] > target: return False
        while nums and nums[-1] == target:
            nums.pop()
            k -= 1
        return dfs([0]*k)
