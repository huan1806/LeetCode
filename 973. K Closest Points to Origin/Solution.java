class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] p : points) {
            pq.offer(p);
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}

//class Solution {
//    public int[][] kClosest(int[][] points, int k) {
//        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
//        int[][] ans = new int[k][2];
//        System.arraycopy(points, 0, ans, 0, k);
//        return ans;
//    }
//}