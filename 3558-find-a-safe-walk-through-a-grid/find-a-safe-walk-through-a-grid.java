class Solution {
    class Pair {
        int cost;
        int row;
        int col;

        Pair(int cost, int row, int col) {
            this.cost = cost;
            this.row = row;
            this.col = col;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[0][0] = grid.get(0).get(0);

        pq.offer(new Pair(dist[0][0], 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            if (cur.cost > dist[cur.row][cur.col])
                continue;

            for (int k = 0; k < 4; k++) {

                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newCost = cur.cost + grid.get(nr).get(nc);

                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new Pair(newCost, nr, nc));
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}