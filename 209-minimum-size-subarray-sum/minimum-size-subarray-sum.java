class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int required = target + prefix[i];
            int j = binarySearch(prefix, required); 
            if (j != -1) {
                minLen = Math.min(minLen, j - i);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    private int binarySearch(int[] prefix, int target) {
        int left = 0, right = prefix.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] >= target) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
