class Solution {
    public int maxDistance(String s, int k) {
        int x = 0;
        int y = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                default: x--; break;
            }
            ans = Math.max(ans, Math.min(i + 1, Math.abs(x) + Math.abs(y) + 2 * k));
        }
        return ans;
    }
}