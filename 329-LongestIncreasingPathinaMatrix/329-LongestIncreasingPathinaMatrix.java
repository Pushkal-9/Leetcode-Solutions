import java.util.*;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];  // DP table to store the length of longest increasing path
        int[] rowDir = {0, 1, 0, -1}; // Directions for moving in 4 directions
        int[] colDir = {1, 0, -1, 0};

        List<int[]> cells = new ArrayList<>();

        // Step 1: Collect all cell positions and sort by value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{i, j});
            }
        }
        // Sort the cells based on their matrix values
        cells.sort(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));

        int maxPath = 0;

        // Step 2: Process in increasing order of matrix values
        for (int[] cell : cells) {
            int i = cell[0], j = cell[1];
            dp[i][j] = 1;  // Each cell itself is a valid path of length 1

            // Update based on the values of its 4 neighbors
            for (int d = 0; d < 4; d++) {
                int ni = i + rowDir[d], nj = j + colDir[d];

                if (isValid(matrix, ni, nj) && matrix[i][j] > matrix[ni][nj]) {
                    dp[i][j] = Math.max(dp[i][j], dp[ni][nj] + 1);
                }
            }

            maxPath = Math.max(maxPath, dp[i][j]);
        }

        return maxPath;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}