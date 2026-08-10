class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                return true;
            }
            // to skip duplicates
            while(low < mid && nums[low] == nums[mid]) {
                low++;
            }
            while(high > mid && nums[high] == nums[mid]) {
                high--;
            }
            // check if left half itself is sorted
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(target <= nums[high] && nums[mid] <= target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}