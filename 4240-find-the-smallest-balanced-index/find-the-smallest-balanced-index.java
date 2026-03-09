/*class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long prefix[] = new long[n];
        long suffix[] = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        suffix[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i];
        }
        for(int i = 0; i < n; i++) {
            long leftSum = (i == 0) ? 0 : prefix[i-1];
            long rightProduct = (i == n-1) ? 1 : suffix[i+1];
            if(leftSum == rightProduct) {
                return i;
            }
        }
        return -1;
    }
}*/
/*class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long prefixSum = 0;
        for(int i = 0; i < n; i++) {
            long rightProduct = 1;
            for(int j = i+1; j < n; j++) {
                rightProduct *= nums[j];
                if(rightProduct > prefixSum) {
                    break;
                }
            }
            if(prefixSum == rightProduct) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}*/
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long[] sum = new long[nums.length];
        long[] pro = new long[nums.length];
        sum[0] = 0;
        pro[nums.length - 1] = 1;
        for(int i = 1; i< nums.length; i++){
            sum[i] = sum[i-1]+nums[i-1];
          
        }
        for(int i=nums.length -2; i>=0; i--){
            pro[i] = pro[i+1]*nums[i+1];
            
        }
        int ans = -1;
        for(int i = 0; i< nums.length; i++){
            if(pro[i] == 0){
                continue;
            }
            if(sum[i]== pro[i]){
                ans = i;
            }
        }
        return ans;
    }
}