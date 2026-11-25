class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] freq = new int[101];

        for (int[] log : logs) {
            int L = log[0];
            int R = log[1];

            freq[L - 1950]++;
            freq[R - 1950]--;
        }

        int maxPopulation = freq[0];
        int year = 1950;

        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];

            if (freq[i] > maxPopulation) {
                maxPopulation = freq[i];
                year = i + 1950;
            }
        }

        return year;
    }
}