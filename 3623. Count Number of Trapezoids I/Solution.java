class Solution {
    public int countTrapezoids(int[][] points) {
        final int mod = (int) 1e9 + 7;
        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) yCount.merge(p[1], 1, Integer::sum);
        long total = 0, sqrSum = 0;
        for (long cnt : yCount.values()) {
            long sides = (cnt * (cnt - 1) >> 1);
            total += sides;
            sqrSum += sides * sides;
        }
        long res = (total * total - sqrSum) >> 1;
        return (int) (res % mod);
    }
}