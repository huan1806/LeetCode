class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        mod = 10**9 + 7
        total, sqr_sum = 0, 0
        y_cnt = defaultdict(int)
        for p in points:
            v = y_cnt[p[1]]
            y_cnt[p[1]] += 1
            total += v
            sqr_sum += v ** 3
        return ((total * total - sqr_sum) >> 1) % mod