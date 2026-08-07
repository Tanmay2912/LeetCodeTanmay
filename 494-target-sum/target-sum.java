class Solution {

    static int subset(int[] arr, int target, int n, int[][] dp) {

        if (n == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[n][target] != -1)
            return dp[n][target];

        int notTake = subset(arr, target, n - 1, dp);

        int take = 0;
        if (arr[n] <= target) {
            take = subset(arr, target - arr[n], n - 1, dp);
        }

        return dp[n][target] = take + notTake;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int x : nums)
            sum += x;

        // Impossible cases
        if (Math.abs(target) > sum)
            return 0;

        if ((sum + target) % 2 != 0)
            return 0;

        int requiredSum = (sum + target) / 2;

        int[][] dp = new int[nums.length][requiredSum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return subset(nums, requiredSum, nums.length - 1, dp);
    }
}