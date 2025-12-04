class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return n;
        Arrays.sort(nums);
        int threshold = nums[n - k];
        int ans = 0;
        for (int num : nums) {
            if (num < threshold) ans++;
            else break;
        }
        return ans;
    }
}
