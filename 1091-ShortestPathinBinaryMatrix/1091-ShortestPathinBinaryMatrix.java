// Last updated: 06/04/2025, 17:40:09
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        vis[0][0] = true;

        int level = 1;

        int[] row = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] col = {1, -1, 0, 0, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pair p = q.poll();
                int r = p.x;
                int c = p.y;

                if (r == m - 1 && c == n - 1) {
                    return level;
                }

                for (int i = 0; i < 8; i++) {
                    int newR = r + row[i];
                    int newC = c + col[i];

                    if (isValid(newR, newC, grid, vis)) {
                        vis[newR][newC] = true; 
                        q.add(new Pair(newR, newC));
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public boolean isValid(int x, int y, int[][] grid, boolean[][] vis) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
               grid[x][y] == 0 && !vis[x][y];
    }

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}