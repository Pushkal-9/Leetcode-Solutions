// Last updated: 29/03/2025, 18:59:38
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int regionId = 2; 
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, regionId);
                    areaMap.put(regionId, area);
                    maxArea = Math.max(maxArea, area);
                    regionId++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int area = 1;

                    for (int[] dir : DIRS) {
                        int r = i + dir[0], c = j + dir[1];
                        if (isInBounds(r, c, n) && grid[r][c] > 1 && seen.add(grid[r][c])) {
                            area += areaMap.get(grid[r][c]);
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea == 0 ? n * n : maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int id) {
        int n = grid.length;
        grid[row][col] = id;
        int area = 1;

        for (int[] dir : DIRS) {
            int r = row + dir[0], c = col + dir[1];
            if (isInBounds(r, c, n) && grid[r][c] == 1) {
                area += dfs(grid, r, c, id);
            }
        }

        return area;
    }

    private boolean isInBounds(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
