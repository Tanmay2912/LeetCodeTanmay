class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            boolean leftOk = (mid == 0) || (nums[mid] > nums[mid - 1]);
            boolean rightOk = (mid == n - 1) || (nums[mid] > nums[mid + 1]);

            if (leftOk && rightOk) {
                return mid; 
            }
            if (mid < n - 1 && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
