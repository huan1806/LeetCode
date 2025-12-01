import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long INF = (long) 1e15;
        long[] best = new long[k];
        Arrays.fill(best, 1, k, INF);
        long ans = Long.MIN_VALUE;
        long pref = 0;
        for (int i = 0; i < n; i++) {
            pref += nums[i];
            int mod = (i + 1) % k;
            ans = Math.max(ans, pref - best[mod]);
            best[mod] = Math.min(best[mod], pref);
        }
        return ans;
    }
}