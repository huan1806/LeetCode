class Solution {
    public int minOperations(int[] nums) {
        int g = nums[0];
        int n = nums.length;
        int count1 = 0;
        for (int num : nums) {
            g = gcd(g, num);
            count1 += num == 1 ? 1 : 0;
        }
        if (g != 1) return -1;
        if (count1 != 0) return n - count1;
        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minMoves = Math.min(minMoves, j - i);
                    break;
                }
            }
        }
        return nums.length + minMoves - 1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}