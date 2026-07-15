class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        for(int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;
            if(rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                cnt += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return cnt;
    }
}