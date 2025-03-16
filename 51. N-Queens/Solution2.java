class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, 0, n, new int[n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return result;
    }

    private void backtrack(List<List<String>> result, int row, int n, int[] positions, boolean[] usedCols, boolean[] usedDiagonal1, boolean[] usedDiagonal2) {
        if (row == n) {
            addConfiguration(result, positions);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!usedCols[col] && !usedDiagonal1[row + col] && !usedDiagonal2[row - col + n - 1]) {
                usedCols[col] = true;
                usedDiagonal1[row + col] = true;
                usedDiagonal2[row - col + n - 1] = true;
                positions[row] = col;
                backtrack(result, row + 1, n, positions, usedCols, usedDiagonal1, usedDiagonal2);
                usedCols[col] = false;
                usedDiagonal1[row + col] = false;
                usedDiagonal2[row - col + n - 1] = false;
            }
        }
    }

    private void addConfiguration(List<List<String>> result, int[] positions) {
        List<String> configuration = new ArrayList<>();
        for (int col : positions) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < col; i++) {
                row.append('.');
            }
            row.append('Q');
            for (int i = col + 1; i < positions.length; i++) {
                row.append('.');
            }
            configuration.add(row.toString());
        }
        result.add(configuration);
    }
}