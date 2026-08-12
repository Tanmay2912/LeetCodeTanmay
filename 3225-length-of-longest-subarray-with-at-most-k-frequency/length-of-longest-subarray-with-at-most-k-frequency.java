class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < nums.length) {
            // Expand window adding current element to the freq map 
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            // shrink window if freq[right] > k
            while(freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left])-1);
                left++;
            }
            // update answer
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}