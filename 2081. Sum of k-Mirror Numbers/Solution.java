class Solution {
    public long kMirror(int k, int n) {
        int count = 0;
        long ans = 0;
        for (int i = 1; i <= 18; i++) {
            int start = (int) Math.pow(10, (i + 1 >> 1) - 1);
            for (int j = start; j < 10 * start; j++) {
                long num = createPalindromic(j, i);
                if (isPalindromicInBaseK(num, k)) {
                    ans += num;
                    if (++count == n) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    private long createPalindromic(int left, int len) {
        long ans = left;
        int temp = len % 2 == 0 ? left : left / 10;
        while (temp > 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return ans;
    }

    private boolean isPalindromicInBaseK(long v, int k) {
        String vk = Long.toString(v, k);
        int left = 0;
        int right = vk.length() - 1;
        while (left < right) {
            if (vk.charAt(left++) != vk.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}