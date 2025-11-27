class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int res = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) {
                res++;
            } else {
                prevEnd = interval[1];
            }
        }
        return res;
    }
}