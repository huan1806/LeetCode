class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;
        long left = 0, right = sum / n;
        long maxTime = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(n, batteries, mid)) {
                maxTime = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxTime;
    }

    private boolean isPossible(int n, int[] batteries, long time) {
        long sum = 0;
        for (int b : batteries) {
            sum += Math.min(b, time);
        }
        return sum >= n * time;
    }
}