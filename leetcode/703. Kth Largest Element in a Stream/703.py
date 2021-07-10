class KthLargest:
    import heapq
    def __init__(self, k: int, nums: List[int]):
        self.k ,self.nums = k,heapq.nlargest(k,nums + [float('-inf')])
        heapq.heapify(self.nums)

    def add(self, val: int) -> int:
        heapq.heappushpop(self.nums,val)
        return self.nums[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)