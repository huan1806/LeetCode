class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int parts = 1;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                start = nums[i];
                parts++;
            }
        }
        return parts;
    }
}