class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long[] range = getRange(nums1, nums2);
        long low = range[0];
        long high = range[3];
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessOrEqual(nums1, nums2, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long[] getRange(int[] nums1, int[] nums2) {
        long[] range = new long[4];
        range[0] = (long) nums1[0] * nums2[0];
        range[1] = (long) nums1[0] * nums2[nums2.length - 1];
        range[2] = (long) nums1[nums1.length - 1] * nums2[0];
        range[3] = (long) nums1[nums1.length - 1] * nums2[nums2.length - 1];
        Arrays.sort(range);
        return range;
    }

    private long countLessOrEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (long a : nums1) {
            if (a == 0) {
                if (mid >= 0) count += nums2.length;
            } else if (a > 0) {
                int low = 0, high = nums2.length - 1;
                while (low <= high) {
                    int m = (low + high) / 2;
                    if (a * nums2[m] > mid) {
                        high = m - 1;
                    } else {
                        low = m + 1;
                    }
                }
                count += high + 1;
            } else {
                int low = 0, high = nums2.length - 1;
                while (low <= high) {
                    int m = (low + high) / 2;
                    if (a * nums2[m] > mid) {
                        low = m + 1;
                    } else {
                        high = m - 1;
                    }
                }
                count += nums2.length - low;
            }
        }
        return count;
    }
}