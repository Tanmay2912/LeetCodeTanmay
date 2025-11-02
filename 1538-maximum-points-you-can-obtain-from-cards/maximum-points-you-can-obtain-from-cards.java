class Solution {
    public int maxScore(int[] cP, int k) {
        int i = 0, j = 0, sum = 0, maxSum = 0;
        for (int x = 0; x < k; x++) {
            sum += cP[cP.length - 1 - x];
        }
        maxSum = sum;
        while (j < k) {
            sum -= cP[cP.length - k + j];
            sum += cP[j];
            maxSum = Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }
}
