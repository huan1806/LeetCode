class Solution:
    def maxSum(self, nums: List[int]) -> int:
        neg = -101
        unique_nums = set()
        for num in nums:
            if num > 0 and num not in unique_nums:
                unique_nums.add(num)
            elif num > neg:
                neg = num
        return neg if len(unique_nums) == 0 else sum(unique_nums)