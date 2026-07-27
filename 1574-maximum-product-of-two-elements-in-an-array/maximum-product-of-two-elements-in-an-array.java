class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int prod = ((nums[nums.length-2]-1)*(nums[nums.length-1]-1));
        return prod;
    }
}