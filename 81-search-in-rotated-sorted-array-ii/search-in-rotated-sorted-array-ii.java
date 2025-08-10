class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;

            while (low < mid && nums[low] == nums[mid]) low++;
            while (high > mid && nums[high] == nums[mid]) high--;
            /*
            if(nums[low] == nums[high] && nums[high] == nums[mid]) {
                low += 1; 
                high -= 1;
                continue;
            }*/

            if(nums[mid] == target) {
                return true;
            }

            // left half being sorted
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;       
                }
                else {
                    low = mid + 1;
                }
            }

            // right half being sorted
            else {
                if(nums[mid] < target && target <= nums[high]) {
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