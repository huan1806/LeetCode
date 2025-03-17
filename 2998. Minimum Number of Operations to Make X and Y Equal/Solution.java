class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{x, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            int steps = current[1];
            if (currentValue == y) {
                return steps;
            }
            if (currentValue > y) {
                if (currentValue % 11 == 0 && !visited.contains(currentValue / 11)) {
                    queue.add(new int[]{currentValue / 11, steps + 1});
                    visited.add(currentValue / 11);
                }
                if (currentValue % 5 == 0 && !visited.contains(currentValue / 5)) {
                    queue.add(new int[]{currentValue / 5, steps + 1});
                    visited.add(currentValue / 5);
                }
                if (!visited.contains(currentValue - 1)) {
                    queue.add(new int[]{currentValue - 1, steps + 1});
                    visited.add(currentValue - 1);
                }
            }
            if (!visited.contains(currentValue + 1)) {
                queue.add(new int[]{currentValue + 1, steps + 1});
                visited.add(currentValue + 1);
            }
        }
        return -1;
    }
}