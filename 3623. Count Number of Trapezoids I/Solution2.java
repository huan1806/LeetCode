class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = (int) 1e9 + 7;
        long total = 0, sqrSum = 0;
        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) {
            long v = yCount.merge(p[1], 1, Integer::sum) - 1;
            total += v;
            sqrSum += v * v * v;
        }
        long res = (total * total - sqrSum) >> 1;
        return (int) (res % MOD);
    }
}
