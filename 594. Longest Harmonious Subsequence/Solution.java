class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer,Integer> entry : count.entrySet()) {
            Integer next = count.get(entry.getKey() + 1);
            if (next == null) {
                continue;
            }
            ans = Math.max(ans, entry.getValue() + next);
        }
        return ans;
    }
}