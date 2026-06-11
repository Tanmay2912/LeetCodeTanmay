/*class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2]; 
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum == target) return target;
                else if (sum < target) left++;
                else right--;
            }
        }
        return result;
    }
}*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closeSum = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum) < Math.abs(target-closeSum)) {
                    closeSum = sum;
                }
                if(sum == target) {
                    closeSum = sum;
                    break;
                }
                if(sum < target) left++;
                else if(sum > target) right--;
            }
        }
        return closeSum;
    }
}