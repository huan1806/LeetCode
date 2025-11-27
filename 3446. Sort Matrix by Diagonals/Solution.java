import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];

        // Sort bottom-left
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int k = 0; k < n; k++) {
            int i = k;
            int j = 0;
            while (i < n) {
                maxHeap.add(grid[i][j]);
                i++;
                j++;
            }
            i = k;
            j = 0;
            while (i < n) {
                ans[i][j] = maxHeap.poll();
                i++;
                j++;
            }
        }

        // Sort top-right
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int k = 1; k < n; k++) {
            int i = 0;
            int j = k;
            while (j < n) {
                minHeap.add(grid[i][j]);
                i++;
                j++;
            }
            i = 0;
            j = k;
            while (j < n) {
                ans[i][j] = minHeap.poll();
                i++;
                j++;
            }
        }
        return ans;
    }
}