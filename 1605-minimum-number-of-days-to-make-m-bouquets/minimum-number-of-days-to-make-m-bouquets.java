class Solution {
    public int findMaxDay(int[] bloomDay) {
        int max = bloomDay[0];
        for (int day : bloomDay) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
    public int noOfBouquestPossible(int[] bloomDay, int day, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; 
                }
            } else {
                flowers = 0; 
            }
        }
        return bouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int low = 1, high = findMaxDay(bloomDay);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int possible = noOfBouquestPossible(bloomDay, mid, k);
            if (possible >= m) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
}
