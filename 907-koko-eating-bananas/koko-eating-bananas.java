class Solution {
    public int findSumOfPile(int[] piles, int mid, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + mid - 1) / mid; 
            if (sum > h) return sum; 
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high; 

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = findSumOfPile(piles, mid, h);

            if (sum <= h) { 
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }

        return ans;
    }
}
