class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0, cnt = 0, prev = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                ans = Math.max(ans, prev + cnt);
                prev = cnt;
                cnt = 0;
            }
        }
        ans = Math.max(ans, prev + cnt);
        if (ans == n) ans--; 
        return ans;
    }
}
