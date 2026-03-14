class Solution {
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int prefixGCD[] = new int[nums.length];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefixGCD);
        long sum = 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            sum += gcd(prefixGCD[left], prefixGCD[right]);
            left++;
            right--;
        }
        return sum;
    }
}