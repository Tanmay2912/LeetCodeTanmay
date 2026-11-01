class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for(int x : nums) {
            sum += x;
            min = Math.min(min, x);
        }
        int ans = sum - nums.length*min;
        return ans;
    }
}