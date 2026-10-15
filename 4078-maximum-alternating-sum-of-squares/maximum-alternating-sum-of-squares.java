class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * (-1);
            }
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] arr = new int[n];
        int j = n - 1;
        // Put larger values at even indexes
        for (int i = 0; i < n; i += 2) {
            arr[i] = nums[j--];
        }
        // Put smaller values at odd indexes
        for (int i = 1; i < n; i += 2) {
            arr[i] = nums[j--];
        }
        long evenSum = 0, oddSum = 0;
        for (int i = 0; i < n; i++) {
            long square = (long) arr[i] * arr[i];
            if (i % 2 == 0) {
                evenSum += square;
            } 
            else {
                oddSum += square;
            }
        }
        return evenSum - oddSum;
    }
}
