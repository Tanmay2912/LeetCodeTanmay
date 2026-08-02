class Solution {
    public int subset(int nums[], int sum, int n, int dp[][]) {
        if (sum == 0) return 1;
        if (n < 0) return 0;
        if (dp[n][sum] != -1) return dp[n][sum];
        if (nums[n] <= sum) {
            if (subset(nums, sum - nums[n], n - 1, dp) == 1 ||
                subset(nums, sum, n - 1, dp) == 1) {
                dp[n][sum] = 1;
            } 
            else {
                dp[n][sum] = 0;
            }
            return dp[n][sum];
        }
        dp[n][sum] = subset(nums, sum, n - 1, dp);
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int val = sum / 2;
        int dp[][] = new int[nums.length][val + 1];
        for (int i = 0; i < nums.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return subset(nums, val, nums.length - 1, dp) == 1;
    }
}