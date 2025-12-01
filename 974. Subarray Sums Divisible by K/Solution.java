class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int pref = 0;
        int[] cnt = new int[k];
        cnt[0] = 1;
        int ans = 0;
        for (int num : nums) {
            pref += num;
            ans += cnt[(pref % k + k) % k]++;
        }
        return ans;
    }
}