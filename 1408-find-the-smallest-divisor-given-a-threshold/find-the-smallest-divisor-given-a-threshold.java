class Solution {
    public int findMaxInArray(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    public int findDivSum(int[] nums, int div) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = findMaxInArray(nums);
        int ans = -1;
        while(low <= high) {
            int mid = (low + high)/2;
            int value = findDivSum(nums, mid);
            if(value <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}