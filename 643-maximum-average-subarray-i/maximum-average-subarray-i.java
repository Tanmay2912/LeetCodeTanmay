class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0, sum = 0;
        double avg = 0.0d;
        //double max = Double.MIN_VALUE; 
        // yaha p negative_infinity taki 1 size array with negative element meh ham negative value return kar rake
        double max = Double.NEGATIVE_INFINITY;
        while(j < nums.length) {
            sum += nums[j];
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                avg = (double)sum/k;
                max = Math.max(max, avg);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
}