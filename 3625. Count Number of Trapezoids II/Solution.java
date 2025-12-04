class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Double, Map<Double, Integer>> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                double dy = points[j][1] - points[i][1];
                double tan = dx == 0 ? Double.MAX_VALUE : dy / dx;
                map.com
            }
        }
    }
}