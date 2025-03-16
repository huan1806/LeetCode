class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        def is_valid(time):
            count = 0
            for rank in ranks:
                count += int(math.sqrt(time / rank))
            return count >= cars


        left, right = 1, min(ranks) * cars * cars
        while left < right:
            mid = (left + right) // 2
            if is_valid(mid):
                right = mid
            else:
                left = mid + 1
        return left