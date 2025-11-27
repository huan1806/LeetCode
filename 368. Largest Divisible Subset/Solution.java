class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = -1;
        int ansIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0] > dp[ansIdx][0]) {
                ansIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int currIndex = ansIdx;
        while (currIndex != -1) {
            ans.add(nums[currIndex]);
            currIndex = dp[currIndex][1];
        }
        return ans;
    }
}