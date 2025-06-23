class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i + maxDistance; j--) {
                if (colors[i] != colors[j]) {
                    maxDistance = Math.max(maxDistance, j - i);
                    break;
                }
            }
        }
        return maxDistance;
    }
}