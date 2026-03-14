class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]%2 == 0) {
                if(mp.containsKey(nums[i])) {
                    mp.put(nums[i], mp.get(nums[i])+1);
                }
                else {
                    mp.put(nums[i], 1);
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0 && mp.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}