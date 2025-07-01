class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (c1, c2) -> c2[0] - c1[0]);
        double prevTime = 0;
        int ans = 0;
        for (int[] car : cars) {
            double t = (double) (target - car[0]) / car[1];
            if (t > prevTime) {
                ans++;
                prevTime = t;
            }
        }
        return ans;
    }
}