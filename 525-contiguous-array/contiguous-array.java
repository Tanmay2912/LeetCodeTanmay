/*class Solution {
    public int findMaxLength(int[] nums) {
        int prefix[] = new int[nums.length];
        prefix[0] = (nums[0] == 0) ? -1 : nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = (nums[i] == 0) ? -1 : nums[i];
            prefix[i] = prefix[i-1] + num;
        }
        for(int i = 0; i < nums.length; i++) {
            System.out.println(prefix[i]);
        }
        return prefix[0];
    }
}*/
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                sum--;
            else
                sum++;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } 
            else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}