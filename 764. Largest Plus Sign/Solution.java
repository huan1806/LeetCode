class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n * n == mines.length) {
            return 0;
        }
        int[][] dp1 = new int[n][n];
        int[][] dp2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], 1);
            Arrays.fill(dp2[i], 1);
        }
        for (int[] m : mines) {
            dp1[m[0]][m[1]] = 0;
            dp2[m[0]][m[1]] = 0;
        }
        int ans = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (dp1[i][j] != 0) dp1[i][j] = dp1[i][j - 1] + 1;
                if (dp2[j][i] != 0) dp2[j][i] = dp2[j - 1][i] + 1;
            }
            for (int j = n - 2; j >= 1; j--) {
                if (dp1[i][j] != 0) dp1[i][j] = Math.min(dp1[i][j], dp1[i][j + 1] + 1);
                if (dp2[j][i] != 0) dp2[j][i] = Math.min(dp2[j][i], dp2[j + 1][i] + 1);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans = Math.max(ans, Math.min(dp1[i][j], dp2[i][j]));
            }
        }
        return ans;
    }
}