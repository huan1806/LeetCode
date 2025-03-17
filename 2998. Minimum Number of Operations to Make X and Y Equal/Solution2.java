class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        int min = Math.min(x - y, 1 + x % 11 + minimumOperationsToMakeEqual(x / 11, y));
        min = Math.min(min, 1 + 11 - x % 11 + minimumOperationsToMakeEqual(x / 11 + 1, y));
        min = Math.min(min, 1 + x % 5 + minimumOperationsToMakeEqual(x / 5, y));
        min = Math.min(min, 1 + 5 - x % 5 + minimumOperationsToMakeEqual(x / 5 + 1, y));
        return min;
    }
}