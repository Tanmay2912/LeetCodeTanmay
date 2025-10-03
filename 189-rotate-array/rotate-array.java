class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 

        int half1 = n - k;
        for (int i = 0; i < half1 / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[half1 - i - 1];
            nums[half1 - i - 1] = temp;
        }

        for (int i = 0; i < k / 2; i++) {
            int temp = nums[half1 + i];
            nums[half1 + i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }
}
