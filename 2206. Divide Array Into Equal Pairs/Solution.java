class Solution {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }
        for (int freq : count) {
            if (freq % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}