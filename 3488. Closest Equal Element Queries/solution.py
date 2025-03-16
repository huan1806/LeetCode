class Solution:
    def solveQueries(self, nums, queries):
        n = len(nums)

        def min_distance_between(a, b):
            return min(a - b, n + b - a) if a > b else min(b - a, n + a - b)

        def find_min_distance(query, indices_list):
            idx = bisect.bisect_left(indices_list, query)
            return min(min_distance_between(indices_list[idx], indices_list[(idx + 1) % len(indices_list)]),
                       min_distance_between(indices_list[idx], indices_list[idx - 1]))

        indices = dict()
        for i in range(0, len(nums)):
            list_indices = indices.get(nums[i], [])
            list_indices.append(i)
            indices[nums[i]] = list_indices
        result = []
        for query in queries:
            num = nums[query]
            list_indices = indices.get(num, [])
            if len(list_indices) > 1:
                min_distance = find_min_distance(query, list_indices)
                result.append(min_distance)
            else:
                result.append(-1)
        return result