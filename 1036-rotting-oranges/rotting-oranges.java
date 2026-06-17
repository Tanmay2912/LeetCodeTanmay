import java.util.*;

class Solution {
    static class Pair {
        int row;
        int col;
        int tm;

        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Check grid, not visited
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int tm = 0;
        int cnt = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;
            int t = curr.tm;

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {

                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if (nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    visited[nRow][nCol] == 0 &&
                    grid[nRow][nCol] == 1) {

                    q.offer(new Pair(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) {
            return -1;
        }

        return tm;
    }
}