class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n-2; i >= 0; i --) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            int left = 0, right = n-1;
            while(left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
                left++;
            }
            return;
        }
        for(int i = n-1; i >= idx; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        int left = idx+1, right = n-1;
        while(left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
    }
}