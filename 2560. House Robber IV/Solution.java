class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < left) {
                left = num;
            }
            if (num > right) {
                right = num;
            }
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (valid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean valid(int[] nums, int k, int v) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= v) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= k;
    }
}