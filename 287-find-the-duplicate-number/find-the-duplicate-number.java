//though this solution is getting accepted but it is not correct as it  odifies the array and the modification of array is not allowed
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0];
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}

/*class Solution {
    public int findSumOfArray(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
    public int findSumOfRange(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }
    public int findDuplicate(int[] nums) {
        int sumA = findSumOfArray(nums);
        int sumR = findSumOfRange(nums.length);
        return Math.abs(sumA-sumR);
    }
}*/

/*floyd cycle detection same as in linked list
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do 
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast);

        fast=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}*/
