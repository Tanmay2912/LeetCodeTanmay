class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int degree = 0;
        for(int freq : map.values()) {
            degree = Math.max(freq, degree);
        }
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(freq == degree) {
                int len = last.get(num) - first.get(num) + 1;
                ans = Math.min(len, ans);
            }
        }
        return ans;
    }
}