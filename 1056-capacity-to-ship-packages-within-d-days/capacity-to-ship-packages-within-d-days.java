class Solution {
    public int findSumOfArray(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        return sum;
    }
    public int findMinDay(int[] weights, int capacity) {
        int sum = 0, days = 1;  
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) {
                return Integer.MAX_VALUE; 
            }
            if (sum + weights[i] > capacity) {
                days++;      
                sum = 0;
            }
            sum += weights[i];
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = findSumOfArray(weights);
        for (int w : weights) {
            low = Math.max(low, w); 
        }
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int minDays = findMinDay(weights, mid);
            if (minDays <= days) {
                ans = mid;         
                high = mid - 1;
            } else {
                low = mid + 1;     
            }
        }
        return ans;
    }
}
