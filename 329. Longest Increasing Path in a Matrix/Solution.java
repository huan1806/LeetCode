class Solution {
    int[][] dp;
    int[][] matrix;
    int m, n;
    int[][] dir = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        this.matrix = matrix;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int maxLen = 1;
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || matrix[ni][nj] <= matrix[i][j]) {
                continue;
            }
            maxLen = Math.max(maxLen, 1 + dfs(ni, nj));
        }
        dp[i][j] = maxLen;
        return maxLen;
    }
}