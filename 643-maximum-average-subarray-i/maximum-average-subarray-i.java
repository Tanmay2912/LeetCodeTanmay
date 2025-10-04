class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1 && nums[0] == -1) {
            return (double)nums[0];
        }
        int i = 0, j = 0, sum = 0;
        double maxavg = Double.NEGATIVE_INFINITY;
        while(j < nums.length) {
            sum += nums[j];
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                maxavg = Math.max(maxavg, (double)sum/k);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return maxavg;
    }
}