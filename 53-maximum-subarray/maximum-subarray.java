// this is kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        // har index p best ending nikal lo
        int bestending = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int c1 = bestending + nums[i];
            int c2 = nums[i];
            // pahle ek optimal best ending nikalo
            bestending = Math.max(c1, c2);
            // fir uss bestending ko ans k liye consider karo
            maxSum = Math.max(maxSum, bestending);
        }
        return maxSum;
    }
}