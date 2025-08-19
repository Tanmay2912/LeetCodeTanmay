class Solution {
    public int binarySearch(int[] prefix, int required) {
        int low = 0, high = prefix.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(prefix[mid] >= required) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) { return 0;}
        int prefix[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int required = target + prefix[i];
            int j = binarySearch(prefix, required);
            if(j != -1) {
                minLen = Math.min(minLen, j-i);
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
}