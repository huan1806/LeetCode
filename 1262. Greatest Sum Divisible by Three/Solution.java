import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int[][] min = new int[3][2];
        int inf = Integer.MAX_VALUE >> 1;
        for (int i = 1; i < 3; i++) {
            Arrays.fill(min[i], inf);
        }
        for (int num : nums) {
            sum += num;
            int r = num % 3;
            if (num < min[r][0]) {
                min[r][1] = min[r][0];
                min[r][0] = num;
            } else if (num < min[r][1]) {
                min[r][1] = num;
            }
        }
        int r = sum % 3;
        if (r == 0) return sum;
        if (r == 1) {
            return sum - Math.min(min[1][0], min[2][0] + min[2][1]);
        }
        return sum - Math.min(min[1][0] + min[1][1], min[2][0]);
    }
}