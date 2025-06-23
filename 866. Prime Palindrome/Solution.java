class Solution {
    public int primePalindrome(int n) {
        int len = (int) Math.log10(n) + 1;
        for (; len <= 9; len++) {
            int start = (int) Math.pow(10, (len + 1 >> 1) - 1);
            int end = 10 * start - 1;
            for (int half = start; half <= end; half++) {
                int num = createPalindromic(half, len);
                if (num >= n && isPrime(num)) {
                    return num;
                }
            }
        }
        return -1;
    }

    private int createPalindromic(int left, int len) {
        int ans = left;
        int temp = len % 2 == 0 ? left : left / 10;
        while (temp > 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return ans;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}