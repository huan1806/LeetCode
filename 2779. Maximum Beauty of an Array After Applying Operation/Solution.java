class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}