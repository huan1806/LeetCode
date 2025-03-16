class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, 0, n, new int[n]);
        return result;
    }

    private void backtrack(List<List<String>> result, int row, int n, int[] positions) {
        if (row == n) {
            addConfiguration(result, positions);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (valid(positions, row, col)) {
                positions[row] = col;
                backtrack(result, row + 1, n, positions);
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

    private boolean valid(int[] positions, int row, int col) {
        for (int usedRow = 0; usedRow < row; usedRow++) {
            int usedCol = positions[usedRow];
            if (usedCol == col || row + col == usedRow + usedCol || row - col == usedRow - usedCol) {
                return false;
            }
        }
        return true;
    }
}