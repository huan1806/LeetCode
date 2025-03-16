class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        sum = 0
        k = 0
        mark_arr = [0] * (n  + 1)
        for i in range(0, n):
            while sum + mark_arr[i] < nums[i]:
                k  += 1
                if k > len(queries):
                    return -1
                left, right, value = queries[k - 1]
                if right >= i:
                    mark_arr[max(left, i)] += value
                    mark_arr[right + 1] -= value
            sum += mark_arr[i]
        return k