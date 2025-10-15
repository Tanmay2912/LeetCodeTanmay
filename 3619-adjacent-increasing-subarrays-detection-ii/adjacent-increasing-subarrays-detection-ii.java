class Solution {
    public boolean isFeasible(int candidateLength, int[] increasingLengths, int n) {
        // need start index such that both adjacent subarrays of length candidateLength fit
        for (int start = 0; start + 2 * candidateLength - 1 < n; start++) {
            if (increasingLengths[start] >= candidateLength && increasingLengths[start + candidateLength] >= candidateLength)
                return true;
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        // increasingLengths[i] = length of strictly increasing subarray starting at index i
        int[] increasingLengths = new int[n];
        increasingLengths[n - 1] = 1;
        for (int idx = n - 2; idx >= 0; idx--) {
            if (nums.get(idx + 1) > nums.get(idx)) increasingLengths[idx] = increasingLengths[idx + 1] + 1;
            else increasingLengths[idx] = 1;
        }
        int low = 0, high = n / 2, maxLength = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (mid == 0) {
                maxLength = 0;
                low = mid + 1;
                continue;
            }
            if (isFeasible(mid, increasingLengths, n)) {
                maxLength = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxLength;
    }
    
}
