class Solution {
    public int sumOfArray(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
    public int countPartitions(int[] nums) {
        int i = 0, sum = 0, count = 0;
        int sumA = sumOfArray(nums);
        for(int j = 1; j < nums.length; j++) {
            sum += nums[j];
            sumA -= nums[j];
            if((Math.abs(sum - sumA))%2 == 0)
                count++;
        }
        return count;
    }
}