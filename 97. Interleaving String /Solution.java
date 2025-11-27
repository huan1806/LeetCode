class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];
        for (int i = 0; i <= c1.length; i++) {
            for (int j = 0; j <= c2.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) dp[i][j] = dp[i][j - 1] && c2[j - 1] == c3[j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j] && c1[i - 1] == c3[i - 1];
                else dp[i][j] = (dp[i - 1][j] && c1[i - 1] == c3[i + j - 1]) || (dp[i][j - 1] && c2[j - 1] == c3[i + j - 1]);
            }
        }
        return dp[c1.length][c2.length];
    }
}