class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } 
            else {
                map.put(i, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                maxCnt += map.get(key);
            }
        }
        return maxCnt;
    }
}
