class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        // Max Heap based on score
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        // Store {score, originalIndex}
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i});
        }
        int rank = 1;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int index = current[1];
            if (rank == 1) {
                ans[index] = "Gold Medal";
            }
            else if (rank == 2) {
                ans[index] = "Silver Medal";
            }
            else if (rank == 3) {
                ans[index] = "Bronze Medal";
            }
            else {
                ans[index] = String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
}