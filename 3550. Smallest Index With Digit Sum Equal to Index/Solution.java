class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            int temp = nums[i];
            while (temp > 0) {
                s += temp % 10;
                temp /= 10;
            }
            if (s == i) {
                return i;
            }
        }
        return -1;
    }
}