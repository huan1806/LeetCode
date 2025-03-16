class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = sum(candies);
        if (totalCandies < k) {
            return 0;
        }
        int left = 1;
        int right = (int) (totalCandies / k);
        int maxCandies = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(candies, k, mid)) {
                maxCandies = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxCandies;
    }

    private long sum(int[] candies) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    private boolean isValid(int[] candies, long k, int t) {
        long x = 0;
        for (int candy : candies) {
            x += candy / t;
        }
        return x >= k;
    }
}