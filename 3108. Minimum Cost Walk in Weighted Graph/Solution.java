class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        Map<Integer, Map<Integer, Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            putToEdgeMap(edge, edgesMap);
        }
        int[] weights = new int[n];
        boolean[] visited = new boolean[n];
        int[] firstVertices = new int[n];
        for (int i = 0; i < n; i++) {
            firstVertices[i] = i;
        }
        for (int v : edgesMap.keySet()) {
            if (!visited[v]) {
                visited[v] = true;
                weights[v] = discover(v, edgesMap, firstVertices, v, visited, Integer.MAX_VALUE);
            }
        }
        return getResult(query, firstVertices, weights);
    }

    private int discover(int u, Map<Integer, Map<Integer, Integer>> edgesMap, int[] firstVertices, int firstIdx,
                         boolean[] visited, int totalWeight) {
        for (var weightEntry : edgesMap.get(u).entrySet()) {
            int v = weightEntry.getKey();
            int w = weightEntry.getValue();
            totalWeight &= w;
            firstVertices[v] = firstIdx;
            if (edgesMap.containsKey(v) && !visited[v]) {
                visited[v] = true;
                totalWeight &= discover(v, edgesMap, firstVertices, firstIdx, visited, totalWeight);
            }
        }
        return totalWeight;
    }

    private void putToEdgeMap(int[] edge, Map<Integer, Map<Integer, Integer>> edgesMap) {
        putToEdgeMap(edgesMap, edge[0], edge[1], edge[2]);
        putToEdgeMap(edgesMap, edge[1], edge[0], edge[2]);
    }

    private static void putToEdgeMap(Map<Integer, Map<Integer, Integer>> edgesMap, int v1, int v2, int w) {
        Map<Integer, Integer> weightMap = edgesMap.computeIfAbsent(v1, k -> new HashMap<>());
        weightMap.put(v2, weightMap.containsKey(v2) ? (weightMap.get(v2) & w) : w);
    }

    private int[] getResult(int[][] query, int[] firstVertices, int[] weights) {
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            if (firstVertices[query[i][0]] == firstVertices[query[i][1]]) {
                result[i] = weights[firstVertices[query[i][0]]];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}