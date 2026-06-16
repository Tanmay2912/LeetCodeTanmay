// this is kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int bestending = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int c1 = bestending + nums[i];
            int c2 = nums[i];
            bestending = Math.max(c1, c2);
            maxSum = Math.max(maxSum, bestending);
        }
        return maxSum;
    }
}