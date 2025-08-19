class Solution {
    public boolean findInRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    public boolean findInColumn(int[][] matrix, int col, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                if (findInRow(matrix[i], target)) {
                    return true;
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            if (target >= matrix[0][j] && target <= matrix[rows - 1][j]) {
                if (findInColumn(matrix, j, target)) {
                    return true;
                }
            }
        }

        return false;
    }
}
