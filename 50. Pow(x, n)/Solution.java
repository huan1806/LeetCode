class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n > 0) {
            return pow(x, n);
        }
        return 1 / pow(x, - (long) n);
    }

    private double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        }
        return x * pow(x, n - 1);
    }
}