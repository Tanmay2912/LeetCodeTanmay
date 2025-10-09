class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long visited[] = new long[n+1];
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                visited[i+1] = Math.max(visited[i+1], visited[i]) + (long) mana[j] * skill[i];
            }
            for (int i = n - 1; i > 0; i--) {
                visited[i] = visited[i+1] - (long) mana[j] * skill[i];
            }
        }
        return visited[n];
    }
}