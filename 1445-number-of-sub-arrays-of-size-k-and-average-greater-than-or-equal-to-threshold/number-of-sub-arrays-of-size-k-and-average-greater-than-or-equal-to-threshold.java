class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int i = 0, j = 0, sum = 0, avg = 0, count = 0;
        while(j < nums.length) {
            sum += nums[j];
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                avg = (int) sum/k;
                if(avg >= threshold) 
                    count++;
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return count;
    }
}