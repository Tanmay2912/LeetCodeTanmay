class Solution {
    public long findSum(int piles[], int k) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += (piles[i] + (long)(k - 1)) / k;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = findSum(piles, mid);
            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}